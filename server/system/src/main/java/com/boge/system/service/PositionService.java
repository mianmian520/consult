package com.boge.system.service;

import com.boge.core.common.base.service.BaseService;
import com.boge.system.entity.PositionEntity;
import com.boge.system.dao.PositionDao;
import com.boge.system.bean.dto.PositionDTO;
import com.boge.system.bean.vo.PositionVO;

/**
 * 职位表(Position)表服务接口
 *
 * @author boge
 * @since 2023-08-17 10:00:19
 */
public interface PositionService extends BaseService<Long, PositionDTO, PositionVO, PositionEntity, PositionDao> {

}
