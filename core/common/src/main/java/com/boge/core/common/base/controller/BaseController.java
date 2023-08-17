package com.boge.core.common.base.controller;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boge.core.common.base.model.BaseDTO;
import com.boge.core.common.base.model.BaseEntity;
import com.boge.core.common.base.model.BaseVO;
import com.boge.core.common.base.model.PageBean;
import com.boge.core.common.base.service.BaseService;
import com.boge.core.common.exception.CustomException;
import com.boge.core.common.model.Validator;
import com.boge.core.common.response.Result;
import io.swagger.annotations.ApiOperation;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 基础控制类
 * @Author boge
 * @Date 2022/9/14 12:59
 */
@Slf4j
@NoArgsConstructor
public abstract class BaseController<T, DTO extends BaseDTO<T>, VO extends BaseVO<T>, Entity extends BaseEntity<T>, Dao extends BaseMapper<Entity>> {

    /**
     * service接口
     * @return service接口
     */
    public abstract BaseService<T, DTO, VO, Entity, Dao> getService();

    /**
     * 分页查询
     * @param dto 请求参数
     */
    @ApiOperation("分页查询")
    @PostMapping("/page")
    public Result<PageBean<VO>> page(@RequestBody DTO dto) {
        return Result.success(getService().selectPage(dto));
    }


    /**
     * 新增
     * @param dto 请求参数
     */
    @ApiOperation("新增")
    @PostMapping("/save")
    public Result<Boolean> save(@Validated(Validator.Create.class) @RequestBody DTO dto) throws CustomException {
        return Result.success("新增成功", getService().save(dto));
    }

    /**
     * 修改
     * @param dto 请求参数
     */
    @ApiOperation("修改")
    @PostMapping("/modify")
    public Result<Boolean> modify(@Validated(Validator.Modify.class) @RequestBody DTO dto) throws CustomException {
        return Result.success("修改成功", getService().modify(dto));
    }

    /**
     * 详情
     * @param id id
     */
    @ApiOperation("详情")
    @GetMapping("/detail/{id}")
    public Result<VO> detail(@PathVariable("id") T id) {
        return Result.success(getService().detail(id));
    }

    /**
     * 删除一个
     * @param id id
     */
    @ApiOperation("根据id删除")
    @DeleteMapping("/delete/{id}")
    public Result<Boolean> delete(@PathVariable("id") T id) throws CustomException {
        return Result.success("删除成功", getService().delete(id));
    }

    /**
     * 删除多个
     * @param ids id集合
     */
    @DeleteMapping("/deletes")
    public Result<Boolean> deletes(@RequestBody T[] ids) {
        return Result.success("删除成功", getService().deletes(ids));
    }
}
