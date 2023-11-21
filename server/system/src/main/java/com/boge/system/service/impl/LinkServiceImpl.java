package com.boge.system.service.impl;

import com.boge.core.common.base.service.impl.BaseServiceImpl;
import com.boge.system.bean.dto.LinkDTO;
import com.boge.system.bean.vo.LinkVO;
import com.boge.system.dao.LinkDao;
import com.boge.system.entity.LinkEntity;
import com.boge.system.service.LinkService;
import org.springframework.stereotype.Service;

/**
 * 友链管理(Link)表服务实现类
 *
 * @author boge
 * @since 2023-09-20 14:49:22
 */
@Service("linkService")
public class LinkServiceImpl extends BaseServiceImpl<Long, LinkDTO, LinkVO, LinkEntity, LinkDao> implements LinkService {

}
