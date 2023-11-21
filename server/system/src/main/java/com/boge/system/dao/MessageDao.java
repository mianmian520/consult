package com.boge.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boge.system.entity.MessageEntity;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 资讯表(Message)表数据库访问层
 *
 * @author boge
 * @since 2023-08-17 10:00:18
 */
@Repository
public interface MessageDao extends BaseMapper<MessageEntity> {
    /**
     * 下篇
     * @param id    id
     * @return  下篇
     */
    MessageEntity next(Long id);

    /**
     * 上篇
     * @param id    id
     * @return  上篇
     */
    MessageEntity prev(Long id);
}

