package com.boge.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.boge.core.common.base.model.PageBean;
import com.boge.core.common.base.service.impl.BaseServiceImpl;
import com.boge.core.common.exception.CustomException;
import com.boge.system.bean.dto.ViewPointDTO;
import com.boge.system.bean.vo.NextAndPrev;
import com.boge.system.bean.vo.ViewPointTagVO;
import com.boge.system.bean.vo.ViewPointVO;
import com.boge.system.dao.ViewPointDao;
import com.boge.system.entity.ViewPointEntity;
import com.boge.system.entity.ViewPointTagEntity;
import com.boge.system.service.ViewPointService;
import com.boge.system.service.ViewPointTagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 观点表(ViewPoint)表服务实现类
 *
 * @author boge
 * @since 2023-08-17 10:00:21
 */
@Service("viewPointService")
public class ViewPointServiceImpl extends BaseServiceImpl<Long, ViewPointDTO, ViewPointVO, ViewPointEntity, ViewPointDao> implements ViewPointService {

    @Resource
    private ViewPointTagService viewPointTagService;

    @Override
    public PageBean<ViewPointVO> selectPage(ViewPointDTO dto) {
        PageBean<ViewPointVO> page = super.selectPage(dto);
        if (CollUtil.isNotEmpty(page.getDatas())) {
            for (ViewPointVO point : page.getDatas()) {
                point.setTags(viewPointTagService.findByPointId(point.getId()));
            }
        }
        return page;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(ViewPointDTO dto) throws CustomException {
        if (dto.getTagIds().size() > 3) {
            throw new CustomException("观点人物标签不能大于3");
        }
        ViewPointEntity pointEntity = BeanUtil.toBean(dto, ViewPointEntity.class);
        boolean save = save(pointEntity);
        List<ViewPointTagEntity> tags = new ArrayList<>(dto.getTagIds().size());
        for (Long tagId : dto.getTagIds()) {
            tags.add(new ViewPointTagEntity(pointEntity.getId(), tagId));
        }
        viewPointTagService.saveBatch(tags);
        return save;
    }

    @Override
    public boolean modify(ViewPointDTO dto) throws CustomException {
        if (dto.getTagIds().size() > 3) {
            throw new CustomException("观点人物标签不能大于3");
        }
        ViewPointEntity pointEntity = BeanUtil.toBean(dto, ViewPointEntity.class);
        boolean save = updateById(pointEntity);
        List<ViewPointTagEntity> tags = new ArrayList<>(dto.getTagIds().size());
        for (Long tagId : dto.getTagIds()) {
            tags.add(new ViewPointTagEntity(pointEntity.getId(), tagId));
        }
        viewPointTagService.remove(Wrappers.lambdaQuery(ViewPointTagEntity.class).eq(ViewPointTagEntity::getPointId, pointEntity.getId()));
        viewPointTagService.saveBatch(tags);
        return save;
    }

    @Override
    public ViewPointVO detail(Long id) {
        ViewPointVO detail = super.detail(id);
        List<ViewPointTagVO> tags = viewPointTagService.findByPointId(id);
        detail.setTags(tags);
        return detail;
    }

    @Override
    public NextAndPrev nextAndPrev(Long id) {
        NextAndPrev nextAndPrev = new NextAndPrev();
        ViewPointEntity entity = getById(id);
        if(entity == null) {
            return nextAndPrev;
        }
        ViewPointEntity next = baseMapper.next(id);
        ViewPointEntity prev = baseMapper.prev(id);
        if (next != null) {
            nextAndPrev.setNextId(next.getId());
            nextAndPrev.setNextTitle(next.getTitle());
        }
        if (prev != null) {
            nextAndPrev.setPrevId(prev.getId());
            nextAndPrev.setPervTitle(prev.getTitle());
        }
        return nextAndPrev;
    }
}
