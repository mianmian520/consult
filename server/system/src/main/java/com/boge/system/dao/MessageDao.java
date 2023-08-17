package com.boge.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boge.system.entity.MessageEntity;
import org.springframework.stereotype.Repository;

/**
 * 资讯表(Message)表数据库访问层
 *
 * @author boge
 * @since 2023-08-17 10:00:18
 */
@Repository
public interface MessageDao extends BaseMapper<MessageEntity> {
}

