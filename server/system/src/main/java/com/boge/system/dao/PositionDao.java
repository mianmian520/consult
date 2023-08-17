package com.boge.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boge.system.entity.PositionEntity;
import org.springframework.stereotype.Repository;

/**
 * 职位表(Position)表数据库访问层
 *
 * @author boge
 * @since 2023-08-17 10:00:19
 */
@Repository
public interface PositionDao extends BaseMapper<PositionEntity> {
}

