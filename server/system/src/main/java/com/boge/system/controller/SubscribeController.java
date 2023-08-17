package com.boge.system.controller;

import com.boge.core.common.base.controller.BaseController;
import com.boge.core.common.base.service.BaseService;
import com.boge.system.bean.dto.SubscribeDTO;
import com.boge.system.bean.vo.SubscribeVO;
import com.boge.system.entity.SubscribeEntity;
import com.boge.system.service.SubscribeService;
import com.boge.system.dao.SubscribeDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import io.swagger.annotations.Api;

/**
 * 预约表(Subscribe)表控制层
 *
 * @author boge
 * @since 2023-08-17 10:00:19
 */
@Api(tags = "预约表控制器", value = "预约表")
@RestController
@RequestMapping("subscribe")
public class SubscribeController extends BaseController<Long, SubscribeDTO, SubscribeVO, SubscribeEntity, SubscribeDao> {

    /**
     * 预约表服务对象
     */
    @Resource
    private SubscribeService subscribeService;

    /**
     * 预约表服务对象
     */
    @Override
    public BaseService<Long, SubscribeDTO, SubscribeVO, SubscribeEntity, SubscribeDao> getService() {
        return subscribeService;
    }
}

