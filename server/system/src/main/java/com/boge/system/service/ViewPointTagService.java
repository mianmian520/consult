package com.boge.system.service;

import com.boge.core.common.base.service.BaseService;
import com.boge.system.bean.dto.ViewPointTagDTO;
import com.boge.system.bean.vo.ViewPointTagVO;
import com.boge.system.dao.ViewPointTagDao;
import com.boge.system.entity.ViewPointTagEntity;

/**
 * 观点-标签表(ViewPointTag)表服务接口
 *
 * @author boge
 * @since 2023-08-17 11:08:01
 */
public interface ViewPointTagService extends BaseService<Long, ViewPointTagDTO, ViewPointTagVO, ViewPointTagEntity, ViewPointTagDao> {

}
