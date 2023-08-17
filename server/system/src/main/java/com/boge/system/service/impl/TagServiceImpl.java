package com.boge.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.boge.core.common.base.service.impl.BaseServiceImpl;
import com.boge.core.common.enums.TagTypeEnum;
import com.boge.core.common.exception.CustomException;
import com.boge.system.bean.dto.TagDTO;
import com.boge.system.bean.vo.TagVO;
import com.boge.system.dao.TagDao;
import com.boge.system.entity.CaseEntity;
import com.boge.system.entity.TagEntity;
import com.boge.system.entity.ViewPointTagEntity;
import com.boge.system.service.CaseService;
import com.boge.system.service.TagService;
import com.boge.system.service.ViewPointTagService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 标签表(Tag)表服务实现类
 *
 * @author boge
 * @since 2023-08-8 08:34:50
 */
@Service("tagService")
public class TagServiceImpl extends BaseServiceImpl<Long, TagDTO, TagVO, TagEntity, TagDao> implements TagService {

    @Lazy
    @Resource
    private CaseService caseService;

    @Resource
    private ViewPointTagService viewPointTagService;

    @Override
    public boolean save(TagDTO dto) {
        Integer max = baseMapper.maxTag(dto.getType());
        TagEntity tag = BeanUtil.toBean(dto, TagEntity.class);
        tag.setSort(max == null ? 1 : max + 1);
        return save(tag);
    }

    @Override
    public boolean delete(Long id) throws CustomException {
        TagEntity tag = getById(id);
        if (tag.getType() == TagTypeEnum.SERVER.getCode()) {
            if (caseService.count(Wrappers.lambdaQuery(CaseEntity.class).eq(CaseEntity::getServerTag, id)) > 0) {
                throw new CustomException(String.format("服务标签【%s】已被案例绑定，不能删除", tag.getTitle()));
            }
        } else if (tag.getType() == TagTypeEnum.PROFESSION.getCode()) {
            if (caseService.count(Wrappers.lambdaQuery(CaseEntity.class).eq(CaseEntity::getProfessionTag, id)) > 0) {
                throw new CustomException(String.format("行业标签【%s】已被案例绑定，不能删除", tag.getTitle()));
            }
        } else if (tag.getType() == TagTypeEnum.VIEWPOINT.getCode()) {
            if (viewPointTagService.count(Wrappers.lambdaQuery(ViewPointTagEntity.class).eq(ViewPointTagEntity::getTagId, id)) > 0) {
                throw new CustomException(String.format("观点标签【%s】已被案例绑定，不能删除", tag.getTitle()));
            }
        }
        return super.delete(id);
    }

    @Override
    public void move(Long id, Integer move) throws CustomException {
        TagEntity tag = getById(id);
        Integer sort = tag.getSort();
        List<TagEntity> tags = new ArrayList<>();
        if (move == null || move == 0) {
            TagEntity next = baseMapper.nextTag(tag.getType(), sort);
            if (next == null) {
                throw new CustomException(String.format("%s已在最下位置,不需要在往下移动", tag.getTitle()));
            }
            tag.setSort(next.getSort());
            next.setSort(sort);
            tags.add(next);
        } else {
            if (sort == 1) {
                throw new CustomException(String.format("%s已在最上位置,不需要在往上移动", tag.getTitle()));
            }
            TagEntity prev = baseMapper.prevTag(tag.getType(), sort);
            tag.setSort(prev.getSort());
            prev.setSort(sort);
            tags.add(prev);
        }
        tags.add(tag);
        updateBatchById(tags);
    }
}