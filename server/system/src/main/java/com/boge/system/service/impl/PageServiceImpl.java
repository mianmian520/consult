package com.boge.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boge.core.common.exception.CustomException;
import com.boge.system.bean.dto.PageBannerDTO;
import com.boge.system.bean.dto.PageBannerItemDTO;
import com.boge.system.bean.vo.PageVO;
import com.boge.system.dao.PageDao;
import com.boge.system.entity.PageBannerEntity;
import com.boge.system.entity.PageBannerItemEntity;
import com.boge.system.entity.PageEntity;
import com.boge.system.service.PageBannerItemService;
import com.boge.system.service.PageBannerService;
import com.boge.system.service.PageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 页面(Page)表服务实现类
 *
 * @author boge
 * @since 2023-08-17 18:03:07
 */
@Service("pageService")
public class PageServiceImpl extends ServiceImpl<PageDao, PageEntity> implements PageService {

    @Resource
    private PageBannerService pageBannerService;

    @Resource
    private PageBannerItemService pageBannerItemService;

    @Override
    public PageVO detail(Long id) {
        PageEntity page = getById(id);
        PageVO pageVO = BeanUtil.toBean(page, PageVO.class);
        pageVO.setBanner(pageBannerService.findFirstByPageId(id));
        pageVO.setSecondBanners(pageBannerService.findSecondByPageId(id));
        return pageVO;
    }

    @Override
    public Boolean saveBanner(PageBannerDTO banner) {
        if (banner.getSort() == null) {
            int max = pageBannerService.maxBanner(banner.getPageId());
            banner.setSort(max + 1);
        }
        return pageBannerService.save(BeanUtil.toBean(banner, PageBannerEntity.class));
    }

    @Override
    public Boolean saveBannerItem(PageBannerItemDTO bannerItem) {
        if (bannerItem.getSort() == null) {
            int max = pageBannerItemService.maxItem(bannerItem.getBannerId());
            bannerItem.setSort(max + 1);
        }
        return pageBannerItemService.save(BeanUtil.toBean(bannerItem, PageBannerItemEntity.class));
    }

    @Override
    public Boolean modifyBanner(PageBannerDTO banner) {
        return pageBannerService.updateById(BeanUtil.toBean(banner, PageBannerEntity.class));
    }

    @Override
    public Boolean modifyBannerItem(PageBannerItemDTO bannerItem) {
        return pageBannerItemService.updateById(BeanUtil.toBean(bannerItem, PageBannerItemEntity.class));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteBanner(Long bannerId) throws CustomException {
        PageBannerEntity banner = pageBannerService.getById(bannerId);
        if (banner.getSort() == 1) {
            throw new CustomException("第一项轮播图不能删除");
        }
        pageBannerService.removeById(bannerId);
        pageBannerService.update(Wrappers.lambdaUpdate(PageBannerEntity.class).setSql("'sort' = 'sort' - 1")
                .eq(PageBannerEntity::getPageId, banner.getPageId()).gt(PageBannerEntity::getSort, banner.getSort()));
        pageBannerItemService.remove(Wrappers.lambdaQuery(PageBannerItemEntity.class).eq(PageBannerItemEntity::getBannerId, bannerId));
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteBannerItem(Long itemId) {
        PageBannerItemEntity item = pageBannerItemService.getById(itemId);
        pageBannerItemService.removeById(itemId);
        pageBannerItemService.update(Wrappers.lambdaUpdate(PageBannerItemEntity.class).setSql("'sort' = 'sort' - 1")
                .eq(PageBannerItemEntity::getBannerId, item.getBannerId()).gt(PageBannerItemEntity::getSort, item.getSort()));
        return true;
    }

}
