package com.boge.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boge.system.entity.PageBannerItemEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 页面栏目配置表(PageBannerItem)表数据库访问层
 *
 * @author boge
 * @since 2023-08-17 18:01:06
 */
@Repository
public interface PageBannerItemDao extends BaseMapper<PageBannerItemEntity> {

    /**
     * 根据栏目id获取最大的sort
     * @param bannerId 栏目id
     * @return  最大sort
     */
    Integer maxItem(Long bannerId);


    /**
     * 获取下一个栏目项
     * @param bannerId    栏目id
     * @param sort      位置
     * @return  下一栏目项
     */
    PageBannerItemEntity nextBannerItem(@Param("bannerId") Long bannerId, @Param("sort") Integer sort);

    /**
     * 获取上一个栏目项
     * @param bannerId    栏目id
     * @param sort      位置
     * @return  上一栏目项
     */
    PageBannerItemEntity pervBannerItem(@Param("bannerId") Long bannerId, @Param("sort") Integer sort);
}

