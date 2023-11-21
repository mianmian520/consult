package com.boge.system.service;

import com.boge.core.common.base.service.BaseService;
import com.boge.core.common.exception.CustomException;
import com.boge.system.bean.dto.TagDTO;
import com.boge.system.bean.vo.TagVO;
import com.boge.system.dao.TagDao;
import com.boge.system.entity.TagEntity;

import java.util.List;

/**
 * 标签表(Tag)表服务接口
 *
 * @author boge
 * @since 2023-08-8 08:34:50
 */
public interface TagService extends BaseService<Long, TagDTO, TagVO, TagEntity, TagDao> {

    /**
     * 移动标签位置
     * @param id    标签id
     * @param move  1、上移 0、下移
     * @throws CustomException 异常
     */
    void move(Long id, Integer move) throws CustomException;

    /**
     * 周围白标签
     * @param id    标签id
     * @param type  标签类型 与id互斥
     * @param num   前后数量默认1
     * @return 标签集合
     */
    List<TagVO> round(Long id, Integer type, Integer num) throws CustomException;
}
