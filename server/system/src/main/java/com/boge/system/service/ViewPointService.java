package com.boge.system.service;

import com.boge.core.common.base.service.BaseService;
import com.boge.system.entity.ViewPointEntity;
import com.boge.system.dao.ViewPointDao;
import com.boge.system.bean.dto.ViewPointDTO;
import com.boge.system.bean.vo.ViewPointVO;

/**
 * 观点表(ViewPoint)表服务接口
 *
 * @author boge
 * @since 2023-08-17 10:00:20
 */
public interface ViewPointService extends BaseService<Long, ViewPointDTO, ViewPointVO, ViewPointEntity, ViewPointDao> {

}
