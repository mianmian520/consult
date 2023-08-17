package com.boge.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boge.core.common.base.model.PageBean;
import com.boge.core.common.base.service.impl.BaseServiceImpl;
import com.boge.system.bean.dto.CaseDTO;
import com.boge.system.bean.vo.CaseVO;
import com.boge.system.dao.CaseDao;
import com.boge.system.entity.CaseEntity;
import com.boge.system.service.CaseService;
import org.springframework.stereotype.Service;

/**
 * 案例表(Case)表服务实现类
 *
 * @author boge
 * @since 2023-08-8 08:35:28
 */
@Service("caseService")
public class CaseServiceImpl extends BaseServiceImpl<Long, CaseDTO, CaseVO, CaseEntity, CaseDao> implements CaseService {

    @Override
    public PageBean<CaseVO> selectPage(CaseDTO dto) {
        Page<CaseVO> page = baseMapper.queryPage(new Page<>(dto.getCurrPage(), dto.getPageSize()), dto);
        return PageBean.convert(page, CaseVO.class);
    }
}
