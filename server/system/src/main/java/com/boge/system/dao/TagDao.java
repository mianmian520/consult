package com.boge.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boge.system.entity.TagEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 标签表(Tag)表数据库访问层
 *
 * @author boge
 * @since 2023-08-8 08:34:50
 */
@Repository
public interface TagDao extends BaseMapper<TagEntity> {
    /**
     * 根据类型获取最大排序值的标签
     * @param type 类型
     * @return 标签
     */
    Integer maxTag(Integer type);

    /**
     * 下一标签
     * @param type  类型
     * @param sort  位置
     * @return  标签
     */
    TagEntity nextTag(@Param("type") Integer type, @Param("sort") Integer sort);

    /**
     * 上一标签
     * @param type  类型
     * @param sort  位置
     * @return  标签
     */
    TagEntity prevTag(@Param("type") Integer type, @Param("sort") Integer sort);
}

