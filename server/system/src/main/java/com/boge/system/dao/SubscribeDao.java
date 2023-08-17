package com.boge.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boge.system.entity.SubscribeEntity;
import org.springframework.stereotype.Repository;

/**
 * 预约表(Subscribe)表数据库访问层
 *
 * @author boge
 * @since 2023-08-17 10:00:19
 */
@Repository
public interface SubscribeDao extends BaseMapper<SubscribeEntity> {
}

