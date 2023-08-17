package com.boge.system.controller;

import com.boge.core.common.base.controller.BaseController;
import com.boge.core.common.base.service.BaseService;
import com.boge.system.bean.dto.TagDTO;
import com.boge.system.bean.vo.TagVO;
import com.boge.system.entity.TagEntity;
import com.boge.system.service.TagService;
import com.boge.system.dao.TagDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import io.swagger.annotations.Api;

/**
 * 标签表(Tag)表控制层
 *
 * @author boge
 * @since 2023-08-8 08:54:50
 */
@Api(tags = "标签控制器", value = "标签表")
@RestController
@RequestMapping("tag")
public class TagController extends BaseController<Long, TagDTO, TagVO, TagEntity, TagDao> {

    /**
     * 标签表服务对象
     */
    @Resource
    private TagService tagService;

    /**
     * 标签表服务对象
     */
    @Override
    public BaseService<Long, TagDTO, TagVO, TagEntity, TagDao> getService() {
        return tagService;
    }
}

