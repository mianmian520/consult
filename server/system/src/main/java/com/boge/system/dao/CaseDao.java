package com.boge.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boge.system.bean.dto.CaseDTO;
import com.boge.system.bean.vo.CaseVO;
import com.boge.system.entity.CaseEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 案例表(Case)表数据库访问层
 *
 * @author boge
 * @since 2023-08-8 08:35:28
 */
@Repository
public interface CaseDao extends BaseMapper<CaseEntity> {
    /**
     * 分页查询案例
     * @param objectPage 分页
     * @param dto       查询参数
     * @return  案例集合
     */
    Page<CaseVO> queryPage(Page<Object> objectPage, @Param("case") CaseDTO dto);

    /**
     * 下篇
     * @param id    id
     * @return  下篇
     */
    CaseEntity next(Long id);

    /**
     * 上篇
     * @param id    id
     * @return  上篇
     */
    CaseEntity prev(Long id);
}

