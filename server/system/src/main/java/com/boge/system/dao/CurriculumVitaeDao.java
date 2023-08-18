package com.boge.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boge.system.bean.dto.CurriculumVitaeDTO;
import com.boge.system.bean.vo.CurriculumVitaeVO;
import com.boge.system.entity.CurriculumVitaeEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 简历表(CurriculumVitae)表数据库访问层
 *
 * @author boge
 * @since 2023-08-17 10:00:16
 */
@Repository
public interface CurriculumVitaeDao extends BaseMapper<CurriculumVitaeEntity> {

    Page<CurriculumVitaeVO> queryPage(Page<Object> objectPage, @Param("curriculumVitae") CurriculumVitaeDTO dto);
}

