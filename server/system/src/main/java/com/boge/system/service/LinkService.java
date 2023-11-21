package com.boge.system.service;

import com.boge.core.common.base.service.BaseService;
import com.boge.system.entity.LinkEntity;
import com.boge.system.dao.LinkDao;
import com.boge.system.bean.dto.LinkDTO;
import com.boge.system.bean.vo.LinkVO;

/**
 * 友链管理(Link)表服务接口
 *
 * @author boge
 * @since 2023-09-20 14:49:22
 */
public interface LinkService extends BaseService<Long, LinkDTO, LinkVO, LinkEntity, LinkDao> {

}
