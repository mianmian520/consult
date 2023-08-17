package com.boge.system.service;

import com.boge.core.common.base.service.BaseService;
import com.boge.system.bean.dto.LeaveWordDTO;
import com.boge.system.bean.vo.LeaveWordVO;
import com.boge.system.dao.LeaveWordDao;
import com.boge.system.entity.LeaveWordEntity;

/**
 * 留言表(LeaveWord)表服务接口
 *
 * @author boge
 * @since 2023-08-17 10:00:17
 */
public interface LeaveWordService extends BaseService<Long, LeaveWordDTO, LeaveWordVO, LeaveWordEntity, LeaveWordDao> {

}
