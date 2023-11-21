package com.boge.system.service;

import com.boge.core.common.base.service.BaseService;
import com.boge.system.bean.dto.ViewPointDTO;
import com.boge.system.bean.vo.NextAndPrev;
import com.boge.system.bean.vo.ViewPointVO;
import com.boge.system.dao.ViewPointDao;
import com.boge.system.entity.ViewPointEntity;

/**
 * 观点表(ViewPoint)表服务接口
 *
 * @author boge
 * @since 2023-08-17 10:00:20
 */
public interface ViewPointService extends BaseService<Long, ViewPointDTO, ViewPointVO, ViewPointEntity, ViewPointDao> {

    /**
     * 上下篇
     * @param id id
     * @return 上下篇
     */
    NextAndPrev nextAndPrev(Long id);
}
