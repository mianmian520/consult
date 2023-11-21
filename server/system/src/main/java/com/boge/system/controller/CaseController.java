package com.boge.system.controller;

import com.boge.core.common.base.controller.BaseController;
import com.boge.core.common.base.service.BaseService;
import com.boge.core.common.exception.CustomException;
import com.boge.core.common.response.Result;
import com.boge.system.bean.dto.CaseDTO;
import com.boge.system.bean.vo.CaseVO;
import com.boge.system.bean.vo.NextAndPrev;
import com.boge.system.dao.CaseDao;
import com.boge.system.entity.CaseEntity;
import com.boge.system.service.CaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 案例表(Case)表控制层
 *
 * @author boge
 * @since 2023-08-8 08:54:50
 */
@Api(tags = "案例控制器", value = "案例表")
@RestController
@RequestMapping("case")
public class CaseController extends BaseController<Long, CaseDTO, CaseVO, CaseEntity, CaseDao> {

    /**
     * 案例表服务对象
     */
    @Resource
    private CaseService caseService;

    /**
     * 案例表服务对象
     */
    @Override
    public BaseService<Long, CaseDTO, CaseVO, CaseEntity, CaseDao> getService() {
        return caseService;
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
        CaseEntity caseEntity = new CaseEntity();
        caseEntity.setId(id);
        caseEntity.setRecommend(recommend == null ? 1 : recommend);
        caseService.updateById(caseEntity);
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
        NextAndPrev nextAndPrev = caseService.nextAndPrev(id);
        return Result.success(nextAndPrev);
    }
}

