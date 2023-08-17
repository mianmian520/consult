package com.boge.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boge.system.bean.vo.ViewPointTagVO;
import com.boge.system.entity.ViewPointTagEntity;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 观点-标签表(ViewPointTag)表数据库访问层
 *
 * @author boge
 * @since 2023-08-17 11:08:01
 */
@Repository
public interface ViewPointTagDao extends BaseMapper<ViewPointTagEntity> {
    /**
     * 根据观点id获取标签
     * @param id    观点id
     * @return      标签
     */
    @Select("select t.*,t1.title tagTitle " +
            "from sys_view_point_tag t inner join sys_tag t1 on t.tag_id = t1.id " +
            "where t.point_id = #{id}")
    List<ViewPointTagVO> findByPointId(Long id);
}

