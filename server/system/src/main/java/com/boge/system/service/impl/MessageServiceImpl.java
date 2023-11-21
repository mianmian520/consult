package com.boge.system.service.impl;

import com.boge.core.common.base.service.impl.BaseServiceImpl;
import com.boge.system.bean.dto.MessageDTO;
import com.boge.system.bean.vo.MessageVO;
import com.boge.system.bean.vo.NextAndPrev;
import com.boge.system.dao.MessageDao;
import com.boge.system.entity.MessageEntity;
import com.boge.system.service.MessageService;
import org.springframework.stereotype.Service;

/**
 * 资讯表(Message)表服务实现类
 *
 * @author boge
 * @since 2023-08-17 10:00:18
 */
@Service("messageService")
public class MessageServiceImpl extends BaseServiceImpl<Long, MessageDTO, MessageVO, MessageEntity, MessageDao> implements MessageService {

    @Override
    public NextAndPrev nextAndPrev(Long id) {
        NextAndPrev nextAndPrev = new NextAndPrev();
        MessageEntity entity = getById(id);
        if(entity == null) {
            return nextAndPrev;
        }
        MessageEntity next = baseMapper.next(id);
        MessageEntity prev = baseMapper.prev(id);
        if (next != null) {
            nextAndPrev.setNextId(next.getId());
            nextAndPrev.setNextTitle(next.getTitle());
        }
        if (prev != null) {
            nextAndPrev.setPrevId(prev.getId());
            nextAndPrev.setPervTitle(prev.getTitle());
        }
        return nextAndPrev;
    }
}
