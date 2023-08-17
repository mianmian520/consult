package com.boge.system.service;

import com.boge.core.common.base.service.BaseService;
import com.boge.core.common.exception.CustomException;
import com.boge.system.bean.dto.LoginDTO;
import com.boge.system.bean.dto.UserDTO;
import com.boge.system.bean.vo.UserVO;
import com.boge.system.dao.UserDao;
import com.boge.system.entity.UserEntity;

/**
 * 系统管理-人员表(User)表服务接口
 *
 * @author boge
 * @since 2023-08-8 08:25:01
 */
public interface UserService extends BaseService<Long, UserDTO, UserVO, UserEntity, UserDao> {

    /**
     * 登录
     * @param dto 登录信息
     * @return  token
     */
    String login(LoginDTO dto) throws CustomException;
}
