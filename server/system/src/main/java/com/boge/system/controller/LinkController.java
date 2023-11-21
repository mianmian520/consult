package com.boge.system.controller;

import com.boge.core.common.base.controller.BaseController;
import com.boge.core.common.base.service.BaseService;
import com.boge.system.bean.dto.LinkDTO;
import com.boge.system.bean.vo.LinkVO;
import com.boge.system.entity.LinkEntity;
import com.boge.system.service.LinkService;
import com.boge.system.dao.LinkDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import io.swagger.annotations.Api;

/**
 * 友链管理(Link)表控制层
 *
 * @author boge
 * @since 2023-09-20 14:49:22
 */
@Api(tags = "友链管理控制器", value = "友链管理")
@RestController
@RequestMapping("link")
public class LinkController extends BaseController<Long, LinkDTO, LinkVO, LinkEntity, LinkDao> {

    /**
     * 友链管理服务对象
     */
    @Resource
    private LinkService linkService;

    /**
     * 友链管理服务对象
     */
    @Override
    public BaseService<Long, LinkDTO, LinkVO, LinkEntity, LinkDao> getService() {
        return linkService;
    }
}

