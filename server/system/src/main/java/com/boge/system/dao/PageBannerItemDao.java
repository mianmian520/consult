package com.boge.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boge.system.entity.PageBannerItemEntity;
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

}

