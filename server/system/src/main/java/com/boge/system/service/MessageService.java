package com.boge.system.service;

import com.boge.core.common.base.service.BaseService;
import com.boge.system.bean.dto.MessageDTO;
import com.boge.system.bean.vo.MessageVO;
import com.boge.system.dao.MessageDao;
import com.boge.system.entity.MessageEntity;

/**
 * 资讯表(Message)表服务接口
 *
 * @author boge
 * @since 2023-08-17 10:00:18
 */
public interface MessageService extends BaseService<Long, MessageDTO, MessageVO, MessageEntity, MessageDao> {

}
