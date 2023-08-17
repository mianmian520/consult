package com.boge.system.service;

import com.boge.core.common.base.service.BaseService;
import com.boge.system.entity.PageBannerEntity;
import com.boge.system.dao.PageBannerDao;
import com.boge.system.bean.dto.PageBannerDTO;
import com.boge.system.bean.vo.PageBannerVO;

import java.util.List;

/**
 * 页面栏目表(PageBanner)表服务接口
 *
 * @author boge
 * @since 2023-08-17 18:01:06
 */
public interface PageBannerService extends BaseService<Long, PageBannerDTO, PageBannerVO, PageBannerEntity, PageBannerDao> {

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
    PageBannerEntity nextBanner(Long pageId, Integer sort);

    /**
     * 获取上一个栏目
     * @param pageId    页面id
     * @param sort      位置
     * @return  上一栏目
     */
    PageBannerEntity pervBanner(Long pageId, Integer sort);


}
