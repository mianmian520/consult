package com.boge.system.controller;

import com.boge.core.common.base.controller.BaseController;
import com.boge.core.common.base.service.BaseService;
import com.boge.system.bean.dto.CurriculumVitaeDTO;
import com.boge.system.bean.vo.CurriculumVitaeVO;
import com.boge.system.entity.CurriculumVitaeEntity;
import com.boge.system.service.CurriculumVitaeService;
import com.boge.system.dao.CurriculumVitaeDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import io.swagger.annotations.Api;

/**
 * 简历表(CurriculumVitae)表控制层
 *
 * @author boge
 * @since 2023-08-17 10:00:16
 */
@Api(tags = "简历表控制器", value = "简历表")
@RestController
@RequestMapping("curriculumVitae")
public class CurriculumVitaeController extends BaseController<Long, CurriculumVitaeDTO, CurriculumVitaeVO, CurriculumVitaeEntity, CurriculumVitaeDao> {

    /**
     * 简历表服务对象
     */
    @Resource
    private CurriculumVitaeService curriculumVitaeService;

    /**
     * 简历表服务对象
     */
    @Override
    public BaseService<Long, CurriculumVitaeDTO, CurriculumVitaeVO, CurriculumVitaeEntity, CurriculumVitaeDao> getService() {
        return curriculumVitaeService;
    }
}

