package com.boge.system.service.impl;

import com.boge.core.common.base.service.impl.BaseServiceImpl;
import com.boge.system.bean.dto.PositionDTO;
import com.boge.system.bean.vo.PositionVO;
import com.boge.system.dao.PositionDao;
import com.boge.system.entity.PositionEntity;
import com.boge.system.service.PositionService;
import org.springframework.stereotype.Service;

/**
 * 职位表(Position)表服务实现类
 *
 * @author boge
 * @since 2023-08-17 10:00:19
 */
@Service("positionService")
public class PositionServiceImpl extends BaseServiceImpl<Long, PositionDTO, PositionVO, PositionEntity, PositionDao> implements PositionService {

}
