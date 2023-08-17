package com.boge.system.service;

import com.boge.core.common.base.service.BaseService;
import com.boge.system.entity.PageBannerItemEntity;
import com.boge.system.dao.PageBannerItemDao;
import com.boge.system.bean.dto.PageBannerItemDTO;
import com.boge.system.bean.vo.PageBannerItemVO;

/**
 * 页面栏目配置表(PageBannerItem)表服务接口
 *
 * @author boge
 * @since 2023-08-17 18:01:07
 */
public interface PageBannerItemService extends BaseService<Long, PageBannerItemDTO, PageBannerItemVO, PageBannerItemEntity, PageBannerItemDao> {

    /**
     * 根据栏目id获取最大的sort
     * @param bannerId 栏目id
     * @return  最大sort
     */
    int maxItem(Long bannerId);

    /**
     * 获取下一个栏目项
     * @param bannerId    栏目id
     * @param sort      位置
     * @return  下一栏目项
     */
    PageBannerItemEntity nextBannerItem(Long bannerId, Integer sort);

    /**
     * 获取上一个栏目项
     * @param bannerId    栏目id
     * @param sort      位置
     * @return  上一栏目项
     */
    PageBannerItemEntity pervBannerItem(Long bannerId, Integer sort);
}
