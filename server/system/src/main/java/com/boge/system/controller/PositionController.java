package com.boge.system.controller;

import com.boge.core.common.base.controller.BaseController;
import com.boge.core.common.base.service.BaseService;
import com.boge.system.bean.dto.PositionDTO;
import com.boge.system.bean.vo.PositionVO;
import com.boge.system.dao.PositionDao;
import com.boge.system.entity.PositionEntity;
import com.boge.system.service.PositionService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 职位表(Position)表控制层
 *
 * @author boge
 * @since 2023-08-17 10:00:19
 */
@Api(tags = "职位表控制器", value = "职位表")
@RestController
@RequestMapping("position")
public class PositionController extends BaseController<Long, PositionDTO, PositionVO, PositionEntity, PositionDao> {

    /**
     * 职位表服务对象
     */
    @Resource
    private PositionService positionService;

    /**
     * 职位表服务对象
     */
    @Override
    public BaseService<Long, PositionDTO, PositionVO, PositionEntity, PositionDao> getService() {
        return positionService;
    }
}

