package com.boge.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boge.core.common.exception.CustomException;
import com.boge.system.bean.dto.PageBannerDTO;
import com.boge.system.bean.dto.PageBannerItemDTO;
import com.boge.system.bean.vo.PageVO;
import com.boge.system.entity.PageEntity;

/**
 * 页面(Page)表服务接口
 *
 * @author boge
 * @since 2023-08-17 18:03:07
 */
public interface PageService extends IService<PageEntity>{

    /**
     * 页面详情
     * @param id 页面id
     * @return  详情
     */
    PageVO detail(Long id);

    /**
     * 保存栏目
     * @param banner 栏目
     * @return  是否成功
     */
    Boolean saveBanner(PageBannerDTO banner);

    /**
     * 保存栏目项
     * @param bannerItem    栏目项
     * @return  是否成
     */
    Boolean saveBannerItem(PageBannerItemDTO bannerItem);

    /**
     * 更新栏目
     * @param banner 栏目
     * @return  是否成功
     */
    Boolean modifyBanner(PageBannerDTO banner);

    /**
     * 更新栏目项
     * @param bannerItem 栏目项
     * @return  是否成功
     */
    Boolean modifyBannerItem(PageBannerItemDTO bannerItem);

    /**
     * 删除栏目
     * @param bannerId    栏目id
     * @return          是否成功
     */
    Boolean deleteBanner(Long bannerId) throws CustomException;

    /**
     * 删除栏目项
     * @param itemId    栏目项id
     * @return          是否成功
     */
    Boolean deleteBannerItem(Long itemId);
}
