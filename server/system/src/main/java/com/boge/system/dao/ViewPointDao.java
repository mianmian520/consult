package com.boge.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boge.system.entity.ViewPointEntity;
import org.springframework.stereotype.Repository;

/**
 * 观点表(ViewPoint)表数据库访问层
 *
 * @author boge
 * @since 2023-08-17 10:00:20
 */
@Repository
public interface ViewPointDao extends BaseMapper<ViewPointEntity> {
}

