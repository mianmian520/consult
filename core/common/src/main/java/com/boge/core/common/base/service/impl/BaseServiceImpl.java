package com.boge.core.common.base.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boge.core.common.annotation.mybatis.MyQuery;
import com.boge.core.common.annotation.mybatis.MyRepeated;
import com.boge.core.common.annotation.mybatis.MySort;
import com.boge.core.common.base.model.BaseDTO;
import com.boge.core.common.base.model.BaseEntity;
import com.boge.core.common.base.model.BaseVO;
import com.boge.core.common.base.model.PageBean;
import com.boge.core.common.base.service.BaseService;
import com.boge.core.common.exception.CustomException;
import com.boge.core.common.utils.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 基础Service实现类
 *
 * @Author boge
 * @Date 2022/9/13 20:25
 */
public class BaseServiceImpl<T, DTO extends BaseDTO<T>, VO extends BaseVO<T>, Entity extends BaseEntity<T>, Dao extends BaseMapper<Entity>> extends ServiceImpl<Dao, Entity> implements BaseService<T, DTO, VO, Entity, Dao> {

    /**
     * voClass
     *
     * @return voClass
     */
    private Class<VO> voClass() {
        return (Class<VO>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
    }

    /**
     * entityClass
     *
     * @return entityClass
     */
    private Class<Entity> entityClass() {
        return (Class<Entity>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[3];
    }

    @Override
    public PageBean<VO> selectPage(DTO dto) {
        QueryWrapper<Entity> wrapper = new QueryWrapper<>();
        for (Field field : dto.getClass().getDeclaredFields()) {
            try {
                if (field.isAnnotationPresent(MyQuery.class)) {
                    field.setAccessible(true);
                    MyQuery myQuery = field.getAnnotation(MyQuery.class);
                    String column = StringUtils.isNotBlank(myQuery.field()) ? StrUtil.toUnderlineCase(myQuery.field()) : StrUtil.toUnderlineCase(field.getName());
                    if (myQuery.like()) {
                        wrapper.like(StrUtil.isNotBlank((String) field.get(dto)), column, field.get(dto));
                    } else {
                        boolean condition;
                        if ("int".equals(field.getType().getTypeName()) || "java.lang.Integer".equals(field.getType().getTypeName()) || "long".equals(field.getType().getTypeName()) || "java.lang.Long".equals(field.getType().getTypeName())) {
                            condition = field.get(dto) != null;
                        } else if ("java.lang.String".equals(field.getType().getTypeName())) {
                            condition = StrUtil.isNotBlank((String) field.get(dto));
                        } else {
                            condition = field.get(dto) != null;
                        }
                        if (myQuery.lt()) {
                            if (myQuery.eq()) {
                                wrapper.le(condition, column, field.get(dto));
                            } else {
                                wrapper.lt(condition, column, field.get(dto));
                            }
                        } else if (myQuery.gt()) {
                            if (myQuery.eq()) {
                                wrapper.ge(condition, column, field.get(dto));
                            } else {
                                wrapper.gt(condition, column, field.get(dto));
                            }
                        } else {
                            wrapper.eq(condition, column, field.get(dto));
                        }
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        if (dto.getClass().isAnnotationPresent(MySort.class)) {
            String[] fields = dto.getClass().getAnnotation(MySort.class).fields();
            int[] methods = dto.getClass().getAnnotation(MySort.class).methods();
            for (int i = 0; i < fields.length; i++) {
                wrapper.orderBy(methods[i] != 0, methods[i] == 1, StrUtil.toUnderlineCase(fields[i]));
            }
        }
        Page<Entity> entityPage = baseMapper.selectPage(new Page<>(dto.getCurrPage(), dto.getPageSize()), wrapper);
        return PageBean.convert(entityPage, voClass());
    }

    @Override
    public boolean save(DTO dto) throws CustomException {
        validRepeated(dto);
        return save(BeanUtil.toBean(dto, entityClass()));
    }

    @Override
    public boolean modify(DTO dto) throws CustomException {
        validRepeated(dto);
        return updateById(BeanUtil.toBean(dto, entityClass()));
    }

    public void validRepeated(DTO dto) throws CustomException {
        List<String> columns = new ArrayList<>();
        List<String> values = new ArrayList<>();
        List<String> comments = new ArrayList<>();
        for (Field field : dto.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(MyRepeated.class)) {
                field.setAccessible(true);
                columns.add(StrUtil.toUnderlineCase(field.getName()));
                comments.add(field.getAnnotation(MyRepeated.class).value());
                try {
                    values.add((String) field.get(dto));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if (CollUtil.isEmpty(columns)) {
            return;
        }
        if (isRepeated(dto.getId(), columns.toArray(new String[0]), values.toArray(new String[0]))) {
            throw new CustomException(String.join("或", comments) + "重复");
        }
    }

    @Override
    public VO detail(T id) {
        if (id instanceof Long) {
            return BeanUtil.toBean(getById((Long) id), voClass());
        } else if (id instanceof Integer) {
            return BeanUtil.toBean(getById((Integer) id), voClass());
        } else {
            return BeanUtil.toBean(getById((String) id), voClass());
        }
    }

    @Override
    public boolean deletes(T[] ids) {
        List<Object> idTemps = new ArrayList<>(ids.length);
        Arrays.stream(ids).forEach(id -> {
            if (id instanceof Long) {
                idTemps.add(id);
            } else if (id instanceof Integer) {
                idTemps.add(((Integer) id).longValue());
            } else {
                idTemps.add(id);
            }
        });
        return removeBatchByIds(idTemps);
    }

    @Override
    public boolean delete(T id) {
        if (id instanceof Long ) {
            return removeById((Long) id);
        } else if (id instanceof Integer) {
            return removeById((Integer) id);
        } else {
            return removeById((String) id);
        }
    }

    @Override
    public boolean isRepeated(T id, String[] columns, String[] values) {
        QueryWrapper<Entity> wrapper = getWrapper(id);
        wrapper.and(w -> Stream.iterate(0, i -> i + 1).limit(columns.length).forEach(index -> {
            if (index == 0) {
                w.eq(columns[index], values[index]);
            } else {
                w.or().eq(columns[index], values[index]);
            }
        }));
        return baseMapper.selectCount(wrapper) > 0;
    }

    @Override
    public boolean isRepeated(T id, String column, String value) {
        return baseMapper.selectCount(getWrapper(id).eq(column, value)) > 0;
    }

    private QueryWrapper<Entity> getWrapper(Object id) {
        QueryWrapper<Entity> wrapper = new QueryWrapper<>();
        if (id != null) {
            if (id instanceof String) {
                wrapper.ne(StrUtil.isNotBlank((String) id), "id", id);
            } else if (id instanceof Long) {
                wrapper.ne((Long) id > 0, "id", id);
            } else if (id instanceof Integer) {
                wrapper.ne((Integer) id > 0, "id", id);
            }
        }
        return wrapper;
    }
}
