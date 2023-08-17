package com.boge.system.service;

import com.boge.core.common.base.service.BaseService;
import com.boge.system.entity.CurriculumVitaeEntity;
import com.boge.system.dao.CurriculumVitaeDao;
import com.boge.system.bean.dto.CurriculumVitaeDTO;
import com.boge.system.bean.vo.CurriculumVitaeVO;

/**
 * 简历表(CurriculumVitae)表服务接口
 *
 * @author boge
 * @since 2023-08-17 10:00:16
 */
public interface CurriculumVitaeService extends BaseService<Long, CurriculumVitaeDTO, CurriculumVitaeVO, CurriculumVitaeEntity, CurriculumVitaeDao> {

}
