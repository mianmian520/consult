package com.boge.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boge.core.common.base.model.PageBean;
import com.boge.core.common.base.service.impl.BaseServiceImpl;
import com.boge.system.bean.dto.CurriculumVitaeDTO;
import com.boge.system.bean.vo.CurriculumVitaeVO;
import com.boge.system.dao.CurriculumVitaeDao;
import com.boge.system.entity.CurriculumVitaeEntity;
import com.boge.system.service.CurriculumVitaeService;
import org.springframework.stereotype.Service;

/**
 * 简历表(CurriculumVitae)表服务实现类
 *
 * @author boge
 * @since 2023-08-17 10:00:16
 */
@Service("curriculumVitaeService")
public class CurriculumVitaeServiceImpl extends BaseServiceImpl<Long, CurriculumVitaeDTO, CurriculumVitaeVO, CurriculumVitaeEntity, CurriculumVitaeDao> implements CurriculumVitaeService {
    @Override
    public PageBean<CurriculumVitaeVO> selectPage(CurriculumVitaeDTO dto) {
        Page<CurriculumVitaeVO> page = baseMapper.queryPage(new Page<>(dto.getCurrPage(), dto.getPageSize()), dto);
        return PageBean.convert(page, CurriculumVitaeVO.class);
    }
}
