package com.boge.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boge.core.common.base.model.PageBean;
import com.boge.core.common.base.service.impl.BaseServiceImpl;
import com.boge.system.bean.dto.CaseDTO;
import com.boge.system.bean.vo.CaseVO;
import com.boge.system.dao.CaseDao;
import com.boge.system.entity.CaseEntity;
import com.boge.system.entity.TagEntity;
import com.boge.system.service.CaseService;
import com.boge.system.service.TagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 案例表(Case)表服务实现类
 *
 * @author boge
 * @since 2023-08-8 08:35:28
 */
@Service("caseService")
public class CaseServiceImpl extends BaseServiceImpl<Long, CaseDTO, CaseVO, CaseEntity, CaseDao> implements CaseService {

    @Resource
    private TagService tagService;

    @Override
    public PageBean<CaseVO> selectPage(CaseDTO dto) {
        Page<CaseVO> page = baseMapper.queryPage(new Page<>(dto.getCurrPage(), dto.getPageSize()), dto);
        return PageBean.convert(page, CaseVO.class);
    }

    @Override
    public CaseVO detail(Long id) {
        CaseVO detail = super.detail(id);
        TagEntity serverTag = tagService.getById(detail.getServerTag());
        detail.setServerTagTitle(serverTag != null ? serverTag.getTitle() : "");
        TagEntity professionTag = tagService.getById(detail.getProfessionTag());
        detail.setProfessionTagTitle(professionTag != null ? professionTag.getTitle() : "");
        return detail;
    }
}
