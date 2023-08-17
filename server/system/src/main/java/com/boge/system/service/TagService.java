package com.boge.system.service;

import com.boge.core.common.base.service.BaseService;
import com.boge.system.entity.TagEntity;
import com.boge.system.dao.TagDao;
import com.boge.system.bean.dto.TagDTO;
import com.boge.system.bean.vo.TagVO;

/**
 * 标签表(Tag)表服务接口
 *
 * @author boge
 * @since 2023-08-8 08:34:50
 */
public interface TagService extends BaseService<Long, TagDTO, TagVO, TagEntity, TagDao> {

}
