package com.boge.system.service.impl;

import com.boge.core.common.base.service.impl.BaseServiceImpl;
import com.boge.system.bean.dto.ViewPointTagDTO;
import com.boge.system.bean.vo.ViewPointTagVO;
import com.boge.system.dao.ViewPointTagDao;
import com.boge.system.entity.ViewPointTagEntity;
import com.boge.system.service.ViewPointTagService;
import org.springframework.stereotype.Service;

/**
 * 观点-标签表(ViewPointTag)表服务实现类
 *
 * @author boge
 * @since 2023-08-17 11:08:01
 */
@Service("viewPointTagService")
public class ViewPointTagServiceImpl extends BaseServiceImpl<Long, ViewPointTagDTO, ViewPointTagVO, ViewPointTagEntity, ViewPointTagDao> implements ViewPointTagService {

}
