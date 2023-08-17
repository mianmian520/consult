package com.boge.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boge.system.entity.LeaveWordEntity;
import org.springframework.stereotype.Repository;

/**
 * 留言表(LeaveWord)表数据库访问层
 *
 * @author boge
 * @since 2023-08-17 10:00:17
 */
@Repository
public interface LeaveWordDao extends BaseMapper<LeaveWordEntity> {
}

