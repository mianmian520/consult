package com.boge.system.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.boge.core.common.base.service.impl.BaseServiceImpl;
import com.boge.core.common.enums.ResultEnum;
import com.boge.core.common.exception.CustomException;
import com.boge.core.common.utils.JwtUtil;
import com.boge.core.common.utils.PasswordUtil;
import com.boge.system.bean.dto.LoginDTO;
import com.boge.system.bean.dto.UserDTO;
import com.boge.system.bean.vo.UserVO;
import com.boge.system.dao.UserDao;
import com.boge.system.entity.UserEntity;
import com.boge.system.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 系统管理-人员表(User)表服务实现类
 *
 * @author boge
 * @since 2023-08-8 08:25:01
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<Long, UserDTO, UserVO, UserEntity, UserDao> implements UserService {

    @Override
    public String login(LoginDTO dto) throws CustomException {
        UserEntity user = getOne(Wrappers.<UserEntity>lambdaQuery().eq(UserEntity::getUserName, dto.getUserName()));
        if (user == null) {
            throw new CustomException(ResultEnum.UNAUTHORIZED.getCode(), "未找到用户,请重新登录");
        }
        if (!user.getPassword().equals(PasswordUtil.encrypt(dto.getPassword()))) {
            throw new CustomException(ResultEnum.UNAUTHORIZED.getCode(), "用户名密码错误");
        }
        return JwtUtil.generateToken(user.getId(), user.getUserName());
    }
}
