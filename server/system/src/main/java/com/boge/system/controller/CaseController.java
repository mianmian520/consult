package com.boge.system.controller;

import com.boge.core.common.base.controller.BaseController;
import com.boge.core.common.base.service.BaseService;
import com.boge.system.bean.dto.CaseDTO;
import com.boge.system.bean.vo.CaseVO;
import com.boge.system.entity.CaseEntity;
import com.boge.system.service.CaseService;
import com.boge.system.dao.CaseDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import io.swagger.annotations.Api;

/**
 * 案例表(Case)表控制层
 *
 * @author boge
 * @since 2023-08-8 08:54:50
 */
@Api(tags = "案例控制器", value = "案例表")
@RestController
@RequestMapping("case")
public class CaseController extends BaseController<Long, CaseDTO, CaseVO, CaseEntity, CaseDao> {

    /**
     * 案例表服务对象
     */
    @Resource
    private CaseService caseService;

    /**
     * 案例表服务对象
     */
    @Override
    public BaseService<Long, CaseDTO, CaseVO, CaseEntity, CaseDao> getService() {
        return caseService;
    }
}

