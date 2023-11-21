package com.boge.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boge.system.entity.ViewPointEntity;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 观点表(ViewPoint)表数据库访问层
 *
 * @author boge
 * @since 2023-08-17 10:00:20
 */
@Repository
public interface ViewPointDao extends BaseMapper<ViewPointEntity> {

    /**
     * 下篇
     * @param id    id
     * @return  下篇
     */
    ViewPointEntity next(Long id);

    /**
     * 上篇
     * @param id    id
     * @return  上篇
     */
    ViewPointEntity prev(Long id);
}

