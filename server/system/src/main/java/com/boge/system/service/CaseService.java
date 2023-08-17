package com.boge.system.service;

import com.boge.core.common.base.service.BaseService;
import com.boge.system.entity.CaseEntity;
import com.boge.system.dao.CaseDao;
import com.boge.system.bean.dto.CaseDTO;
import com.boge.system.bean.vo.CaseVO;

/**
 * 案例表(Case)表服务接口
 *
 * @author boge
 * @since 2023-08-8 08:35:28
 */
public interface CaseService extends BaseService<Long, CaseDTO, CaseVO, CaseEntity, CaseDao> {

}
