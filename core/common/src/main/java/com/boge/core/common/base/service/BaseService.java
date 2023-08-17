package com.boge.core.common.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boge.core.common.base.model.BaseDTO;
import com.boge.core.common.base.model.BaseEntity;
import com.boge.core.common.base.model.BaseVO;
import com.boge.core.common.base.model.PageBean;
import com.boge.core.common.exception.CustomException;

/**
 * 基础Service接口
 * @Author boge
 * @Date 2022/9/13 20:24
 */
public interface BaseService<T, DTO extends BaseDTO<T>, VO extends BaseVO<T>, Entity extends BaseEntity<T>, Dao> extends IService<Entity> {

    /**
     * 分页查询
     * @param dto 请求参数
     * @return 分页数据
     */
    PageBean<VO> selectPage(DTO dto);

    /**
     * 新增
     * @param dto 请求参数
     * @return 是否成功
     * @throws  CustomException 出错时异常
     */
    boolean save(DTO dto) throws CustomException;

    /**
     * 修改
     * @param dto 请求参数
     * @return 是否成功
     * @throws  CustomException 出错时异常
     */
    boolean modify(DTO dto) throws CustomException;

    /**
     * 详情
     * @param id id
     * @return VO
     */
    VO detail(T id);

    /**
     * 批量删除
     * @param ids id集合
     * @return 是否成功
     */
    boolean deletes(T[] ids);

    /**
     * 单个删除
     * @param id id
     * @return 是否成功
     */
    boolean delete(T id);

    /**
     * 字段是否重复
     * @param id id 为空则不根据id匹配，不为空则排除id
     * @param columns 字段集合
     * @param values 值集合
     * @return 是否重复
     */
    boolean isRepeated(T id, String[] columns, String[] values);

    /**
     * 字段是否重复
     * @param id id 为空则不根据id匹配，不为空则排除id
     * @param column 字段
     * @param value 值
     * @return 是否重复
     */
    boolean isRepeated(T id, String column, String value);
}
