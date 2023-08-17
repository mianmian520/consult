package com.boge.system.controller;

import com.boge.core.common.base.controller.BaseController;
import com.boge.core.common.base.service.BaseService;
import com.boge.system.bean.dto.LeaveWordDTO;
import com.boge.system.bean.vo.LeaveWordVO;
import com.boge.system.dao.LeaveWordDao;
import com.boge.system.entity.LeaveWordEntity;
import com.boge.system.service.LeaveWordService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 留言表(LeaveWord)表控制层
 *
 * @author boge
 * @since 2023-08-17 10:00:16
 */
@Api(tags = "留言表控制器", value = "留言表")
@RestController
@RequestMapping("leaveWord")
public class LeaveWordController extends BaseController<Long, LeaveWordDTO, LeaveWordVO, LeaveWordEntity, LeaveWordDao> {

    /**
     * 留言表服务对象
     */
    @Resource
    private LeaveWordService leaveWordService;

    /**
     * 留言表服务对象
     */
    @Override
    public BaseService<Long, LeaveWordDTO, LeaveWordVO, LeaveWordEntity, LeaveWordDao> getService() {
        return leaveWordService;
    }
}

