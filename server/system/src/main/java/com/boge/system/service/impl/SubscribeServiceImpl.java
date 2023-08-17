package com.boge.system.service.impl;

import com.boge.core.common.base.service.impl.BaseServiceImpl;
import com.boge.system.bean.dto.SubscribeDTO;
import com.boge.system.bean.vo.SubscribeVO;
import com.boge.system.dao.SubscribeDao;
import com.boge.system.entity.SubscribeEntity;
import com.boge.system.service.SubscribeService;
import org.springframework.stereotype.Service;

/**
 * 预约表(Subscribe)表服务实现类
 *
 * @author boge
 * @since 2023-08-17 10:00:20
 */
@Service("subscribeService")
public class SubscribeServiceImpl extends BaseServiceImpl<Long, SubscribeDTO, SubscribeVO, SubscribeEntity, SubscribeDao> implements SubscribeService {

}
