package com.boge.system.controller;

import com.boge.core.common.base.controller.BaseController;
import com.boge.core.common.base.service.BaseService;
import com.boge.core.common.exception.CustomException;
import com.boge.core.common.response.Result;
import com.boge.system.bean.dto.TagDTO;
import com.boge.system.bean.vo.TagVO;
import com.boge.system.dao.TagDao;
import com.boge.system.entity.TagEntity;
import com.boge.system.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    /**
     * 移动位置
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "标签id", required = true),
            @ApiImplicitParam(name = "move", value = "上移下移 0、下移 1、上移，为空下移")
    })
    @ApiOperation("移动位置，上移下移")
    @PutMapping("/move/{id}")
    public Result<Object> move(@PathVariable("id") Long id, Integer move) throws CustomException {
        tagService.move(id, move);
        return Result.success("移动成功", null);
    }
}

