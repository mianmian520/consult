package com.boge.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boge.system.entity.LinkEntity;
import org.springframework.stereotype.Repository;

/**
 * 友链管理(Link)表数据库访问层
 *
 * @author boge
 * @since 2023-09-20 14:49:22
 */
@Repository
public interface LinkDao extends BaseMapper<LinkEntity> {
}

