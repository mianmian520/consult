package com.boge.system.service.impl;

import com.boge.core.common.base.service.impl.BaseServiceImpl;
import com.boge.system.bean.dto.ViewPointDTO;
import com.boge.system.bean.vo.ViewPointVO;
import com.boge.system.dao.ViewPointDao;
import com.boge.system.entity.ViewPointEntity;
import com.boge.system.service.ViewPointService;
import org.springframework.stereotype.Service;

/**
 * 观点表(ViewPoint)表服务实现类
 *
 * @author boge
 * @since 2023-08-17 10:00:21
 */
@Service("viewPointService")
public class ViewPointServiceImpl extends BaseServiceImpl<Long, ViewPointDTO, ViewPointVO, ViewPointEntity, ViewPointDao> implements ViewPointService {

}
