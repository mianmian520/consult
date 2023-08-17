package com.boge.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boge.system.entity.TagEntity;
import org.springframework.stereotype.Repository;

/**
 * 标签表(Tag)表数据库访问层
 *
 * @author boge
 * @since 2023-08-8 08:34:50
 */
@Repository
public interface TagDao extends BaseMapper<TagEntity> {
}

