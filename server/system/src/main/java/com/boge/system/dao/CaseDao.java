package com.boge.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boge.system.entity.CaseEntity;
import org.springframework.stereotype.Repository;

/**
 * 案例表(Case)表数据库访问层
 *
 * @author boge
 * @since 2023-08-8 08:35:28
 */
@Repository
public interface CaseDao extends BaseMapper<CaseEntity> {
}

