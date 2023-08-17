package com.boge.system.service.impl;

import com.boge.core.common.base.service.impl.BaseServiceImpl;
import com.boge.system.bean.dto.LeaveWordDTO;
import com.boge.system.bean.vo.LeaveWordVO;
import com.boge.system.dao.LeaveWordDao;
import com.boge.system.entity.LeaveWordEntity;
import com.boge.system.service.LeaveWordService;
import org.springframework.stereotype.Service;

/**
 * 留言表(LeaveWord)表服务实现类
 *
 * @author boge
 * @since 2023-08-17 10:00:17
 */
@Service("leaveWordService")
public class LeaveWordServiceImpl extends BaseServiceImpl<Long, LeaveWordDTO, LeaveWordVO, LeaveWordEntity, LeaveWordDao> implements LeaveWordService {

}
