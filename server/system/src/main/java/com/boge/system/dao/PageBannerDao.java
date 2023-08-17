package com.boge.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boge.system.bean.vo.PageBannerVO;
import com.boge.system.entity.PageBannerEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 页面栏目表(PageBanner)表数据库访问层
 *
 * @author boge
 * @since 2023-08-17 18:01:06
 */
@Repository
public interface PageBannerDao extends BaseMapper<PageBannerEntity> {
    /**
     * 获取页面第一个banner（轮播）
     * @param pageId    页面id
     * @return      第一个栏目
     */
    PageBannerVO findFirstByPageId(Long pageId);

    /**
     * 获取页面第一个之外的banner
     * @param pageId    页面id
     * @return      第一个之外的banner
     */
    List<PageBannerVO> findSecondByPageId(Long pageId);


    /**
     * 最大banner的sort
     * @param pageId    页面id
     * @return  最大sort值
     */
    int maxBanner(Long pageId);

    /**
     * 获取下一个栏目
     * @param pageId    页面id
     * @param sort      位置
     * @return  下一栏目
     */
    PageBannerEntity nextBanner(@Param("pageId") Long pageId, @Param("sort") Integer sort);

    /**
     * 获取上一个栏目
     * @param pageId    页面id
     * @param sort      位置
     * @return  下一栏目
     */
    PageBannerEntity pervBanner(@Param("pageId") Long pageId, @Param("sort") Integer sort);

}

