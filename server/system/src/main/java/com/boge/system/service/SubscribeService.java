package com.boge.system.service;

import com.boge.core.common.base.service.BaseService;
import com.boge.system.bean.dto.SubscribeDTO;
import com.boge.system.bean.vo.SubscribeVO;
import com.boge.system.dao.SubscribeDao;
import com.boge.system.entity.SubscribeEntity;

/**
 * 预约表(Subscribe)表服务接口
 *
 * @author boge
 * @since 2023-08-17 10:00:20
 */
public interface SubscribeService extends BaseService<Long, SubscribeDTO, SubscribeVO, SubscribeEntity, SubscribeDao> {

}
