package com.boge.system.controller;

import com.boge.core.common.exception.CustomException;
import com.boge.core.common.response.Result;
import com.boge.system.bean.dto.PageBannerDTO;
import com.boge.system.bean.dto.PageBannerItemDTO;
import com.boge.system.bean.vo.PageVO;
import com.boge.system.entity.PageEntity;
import com.boge.system.service.PageService;
import io.swagger.annotations.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author boge
 * @Date 2023/8/17 18:01
 */
@Api(tags = "页面(首页)控制器", value = "页面表")
@RestController
@RequestMapping("page")
public class PageController {

    @Resource
    private PageService pageService;

    /**
     * 页面标题
     * @return 页面集合
     */
    @ApiOperation("获取所有的页面")
    @GetMapping("all")
    public Result<List<PageEntity>> all() {
        return Result.success(pageService.list());
    }

    /**
     * 页面详情
     * @param id 页面id
     * @return  页面详情
     */
    @ApiOperation("根据id获取页面详情")
    @GetMapping("/detail/{id}")
    public Result<PageVO> detail(@PathVariable("id") Long id) {
        return Result.success(pageService.detail(id));
    }

    /**
     * 保存栏目
     * @param banner 栏目
     * @return  是否成功
     */
    @ApiOperation("保存栏目")
    @PostMapping("/save/banner")
    public Result<Boolean> saveBanner(@Validated @RequestBody PageBannerDTO banner) {
        return Result.success("保存成功", pageService.saveBanner(banner));
    }

    /**
     * 保存栏目项
     * @param bannerItem 栏目项
     * @return  是否成功
     */
    @ApiOperation("保存栏目项")
    @PostMapping("/save/banner/item")
    public Result<Boolean> saveBannerItem(@Validated @RequestBody PageBannerItemDTO bannerItem) {
        return Result.success("保存成功", pageService.saveBannerItem(bannerItem));
    }

    /**
     * 更新栏目
     * @param banner 栏目
     * @return  是否成功
     */
    @ApiOperation("更新栏目")
    @PostMapping("/modify/banner")
    public Result<Boolean> modifyBanner(@Validated @RequestBody PageBannerDTO banner) {
        return Result.success("更新成功", pageService.modifyBanner(banner));
    }

    /**
     * 更新栏目项
     * @param bannerItem 栏目项
     * @return  是否成功
     */
    @ApiOperation("更新栏目项")
    @PostMapping("/modify/banner/item")
    public Result<Boolean> modifyBannerItem(@Validated @RequestBody PageBannerItemDTO bannerItem) {
        return Result.success("更新成功", pageService.modifyBannerItem(bannerItem));
    }

    /**
     * 删除栏目
     * @param bannerId    栏目id
     * @return          是否成功
     */
    @ApiOperation("删除栏目")
    @DeleteMapping("/delete/banner/{bannerId}")
    public Result<Object> deleteBanner(@PathVariable("bannerId") @ApiParam("栏目id") Long bannerId) throws CustomException {
        return Result.success("删除成功", pageService.deleteBanner(bannerId));
    }


    /**
     * 删除栏目项
     * @param itemId    栏目项id
     * @return          是否成功
     */
    @ApiOperation("删除栏目项")
    @DeleteMapping("/delete/banner/item/{itemId}")
    public Result<Object> deleteBannerItem(@PathVariable("itemId") @ApiParam("栏目id") Long itemId) {
        return Result.success("删除成功", pageService.deleteBannerItem(itemId));
    }

    /**
     * 移动栏目位置
     * @param id 栏目id
     * @param move 上移下移 0、下移 1、上移，为空下移
     * @return 是否成功
     * @throws CustomException 异常
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "栏目id", required = true, dataTypeClass = Long.class),
            @ApiImplicitParam(name = "move", value = "上移下移 0、下移 1、上移，为空下移", dataTypeClass = Integer.class)
    })
    @ApiOperation("栏目移动位置，上移下移")
    @PutMapping("/move/banner/{id}")
    public Result<Object> moveBanner(@PathVariable("id") Long id, Integer move) throws CustomException {
        pageService.moveBanner(id, move);
        return Result.success("移动成功", null);
    }

    /**
     * 移动栏目项位置
     * @param id 栏目项id
     * @param move 上移下移 0、下移 1、上移，为空下移
     * @return 是否成功
     * @throws CustomException 异常
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "栏目项id", required = true),
            @ApiImplicitParam(name = "move", value = "上移下移 0、下移 1、上移，为空下移")
    })
    @ApiOperation("栏目想移动位置，上移下移")
    @PutMapping("/move/banner/item/{id}")
    public Result<Object> moveBannerItem(@PathVariable("id") Long id, Integer move) throws CustomException {
        pageService.moveBannerItem(id, move);
        return Result.success("移动成功", null);
    }
}
