package com.boge.core.common.base.model;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.List;

/**
 * 统一分页返回数据
 * @Author boge
 * @Date 2022/9/13 22:44
 */
@Data
public class PageBean<T> {

    protected long total;
    protected long pageSize;
    protected long currPage;

    protected List<T> datas;

    public PageBean(IPage<T> page) {
        this.total = page.getTotal();
        this.pageSize = page.getSize();
        this.currPage = page.getCurrent();
        this.datas = page.getRecords();
    }

    public static <T> PageBean<T> convert(IPage<?> iPage, Class<T> clazz) {
        if (iPage.getTotal() <= 0) {
            return new PageBean<>(new Page<>());
        }
        List<T> list = BeanUtil.copyToList(iPage.getRecords(), clazz);
        Page<T> page = new Page<>(iPage.getCurrent(), iPage.getSize(), iPage.getTotal());
        page.setRecords(list);
        return new PageBean<>(page);
    }
}
