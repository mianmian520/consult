package com.boge.system.service.impl;

import com.boge.core.common.base.service.impl.BaseServiceImpl;
import com.boge.system.bean.dto.PageBannerDTO;
import com.boge.system.bean.vo.PageBannerVO;
import com.boge.system.dao.PageBannerDao;
import com.boge.system.entity.PageBannerEntity;
import com.boge.system.service.PageBannerService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 页面栏目表(PageBanner)表服务实现类
 *
 * @author boge
 * @since 2023-08-17 18:01:06
 */
@Service("pageBannerService")
public class PageBannerServiceImpl extends BaseServiceImpl<Long, PageBannerDTO, PageBannerVO, PageBannerEntity, PageBannerDao> implements PageBannerService {

    @Override
    public PageBannerVO findFirstByPageId(Long pageId) {
        return baseMapper.findFirstByPageId(pageId);
    }

    @Override
    public List<PageBannerVO> findSecondByPageId(Long pageId) {
        return baseMapper.findSecondByPageId(pageId);
    }

    @Override
    public int maxBanner(Long pageId) {
        return baseMapper.maxBanner(pageId);
    }
}
