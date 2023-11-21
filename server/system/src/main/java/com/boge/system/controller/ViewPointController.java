package com.boge.system.controller;

import com.boge.core.common.base.controller.BaseController;
import com.boge.core.common.base.service.BaseService;
import com.boge.core.common.exception.CustomException;
import com.boge.core.common.response.Result;
import com.boge.system.bean.dto.ViewPointDTO;
import com.boge.system.bean.vo.NextAndPrev;
import com.boge.system.bean.vo.ViewPointVO;
import com.boge.system.dao.ViewPointDao;
import com.boge.system.entity.ViewPointEntity;
import com.boge.system.service.ViewPointService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 改变推荐状态
     * @param id        案例id
     * @param recommend 推荐状态 0、不推荐 1、推荐
     * @return  result
     */
    @ApiOperation("改变推荐状态")
    @PutMapping("/recommend/{id}")
    public Result<Object> recommend(@PathVariable("id") Long id, @RequestParam(required = false) Integer recommend) throws CustomException {
        if (recommend != null && recommend != 1 && recommend != 0) {
            throw new CustomException("推荐参数有误");
        }
        ViewPointEntity entity = new ViewPointEntity();
        entity.setId(id);
        entity.setRecommend(recommend == null ? 1 : recommend);
        viewPointService.updateById(entity);
        return Result.success(recommend == null || recommend  == 1 ? "开启推荐成功" : "关闭推荐成功", null);
    }


    /**
     * 上、下一篇
     * @param id        案例id
     * @return  result
     */
    @ApiOperation("上、下一篇")
    @GetMapping("/nextAndPrev/{id}")
    public Result<NextAndPrev> nextAndPrev(@PathVariable("id") Long id) {
        NextAndPrev nextAndPrev = viewPointService.nextAndPrev(id);
        return Result.success(nextAndPrev);
    }
}

