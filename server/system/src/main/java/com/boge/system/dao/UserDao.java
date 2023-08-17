package com.boge.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boge.system.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * 系统管理-人员表(User)表数据库访问层
 *
 * @author boge
 * @since 2023-08-8 08:25:01
 */
@Repository
public interface UserDao extends BaseMapper<UserEntity> {
}

