package com.boge.system.controller;

import com.boge.core.common.base.controller.BaseController;
import com.boge.core.common.base.service.BaseService;
import com.boge.system.bean.dto.MessageDTO;
import com.boge.system.bean.vo.MessageVO;
import com.boge.system.entity.MessageEntity;
import com.boge.system.service.MessageService;
import com.boge.system.dao.MessageDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import io.swagger.annotations.Api;

/**
 * 资讯表(Message)表控制层
 *
 * @author boge
 * @since 2023-08-17 10:00:17
 */
@Api(tags = "资讯表控制器", value = "资讯表")
@RestController
@RequestMapping("message")
public class MessageController extends BaseController<Long, MessageDTO, MessageVO, MessageEntity, MessageDao> {

    /**
     * 资讯表服务对象
     */
    @Resource
    private MessageService messageService;

    /**
     * 资讯表服务对象
     */
    @Override
    public BaseService<Long, MessageDTO, MessageVO, MessageEntity, MessageDao> getService() {
        return messageService;
    }
}

