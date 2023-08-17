package com.boge.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boge.system.entity.ViewPointTagEntity;
import org.springframework.stereotype.Repository;

/**
 * 观点-标签表(ViewPointTag)表数据库访问层
 *
 * @author boge
 * @since 2023-08-17 11:08:01
 */
@Repository
public interface ViewPointTagDao extends BaseMapper<ViewPointTagEntity> {
}

