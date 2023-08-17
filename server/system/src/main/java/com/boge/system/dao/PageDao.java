package com.boge.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boge.system.entity.PageEntity;
import org.springframework.stereotype.Repository;

/**
 * 页面(Page)表数据库访问层
 *
 * @author boge
 * @since 2023-08-17 18:04:52
 */
@Repository
public interface PageDao extends BaseMapper<PageEntity> {
}

