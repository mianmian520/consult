package com.boge.system.controller;

import com.boge.core.common.base.controller.BaseController;
import com.boge.core.common.base.service.BaseService;
import com.boge.system.bean.dto.ViewPointDTO;
import com.boge.system.bean.vo.ViewPointVO;
import com.boge.system.dao.ViewPointDao;
import com.boge.system.entity.ViewPointEntity;
import com.boge.system.service.ViewPointService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 观点表(ViewPoint)表控制层
 *
 * @author boge
 * @since 2023-08-17 10:00:20
 */
@Api(tags = "观点表控制器", value = "观点表")
@RestController
@RequestMapping("viewPoint")
public class ViewPointController extends BaseController<Long, ViewPointDTO, ViewPointVO, ViewPointEntity, ViewPointDao> {

    /**
     * 观点表服务对象
     */
    @Resource
    private ViewPointService viewPointService;

    /**
     * 观点表服务对象
     */
    @Override
    public BaseService<Long, ViewPointDTO, ViewPointVO, ViewPointEntity, ViewPointDao> getService() {
        return viewPointService;
    }
}

