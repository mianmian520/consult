package com.boge.system.service.impl;

import com.boge.core.common.base.service.impl.BaseServiceImpl;
import com.boge.system.bean.dto.TagDTO;
import com.boge.system.bean.vo.TagVO;
import com.boge.system.dao.TagDao;
import com.boge.system.entity.TagEntity;
import com.boge.system.service.TagService;
import org.springframework.stereotype.Service;

/**
 * 标签表(Tag)表服务实现类
 *
 * @author boge
 * @since 2023-08-8 08:34:50
 */
@Service("tagService")
public class TagServiceImpl extends BaseServiceImpl<Long, TagDTO, TagVO, TagEntity, TagDao> implements TagService {

}
