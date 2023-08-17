package com.boge.system.service.impl;

import com.boge.core.common.base.service.impl.BaseServiceImpl;
import com.boge.system.bean.dto.PageBannerItemDTO;
import com.boge.system.bean.vo.PageBannerItemVO;
import com.boge.system.dao.PageBannerItemDao;
import com.boge.system.entity.PageBannerItemEntity;
import com.boge.system.service.PageBannerItemService;
import org.springframework.stereotype.Service;

/**
 * 页面栏目配置表(PageBannerItem)表服务实现类
 *
 * @author boge
 * @since 2023-08-17 18:01:07
 */
@Service("pageBannerItemService")
public class PageBannerItemServiceImpl extends BaseServiceImpl<Long, PageBannerItemDTO, PageBannerItemVO, PageBannerItemEntity, PageBannerItemDao> implements PageBannerItemService {

    @Override
    public int maxItem(Long bannerId) {
        Integer maxItem = baseMapper.maxItem(bannerId);
        return maxItem == null ? 0 : maxItem;
    }
}
