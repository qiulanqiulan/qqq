package com.pandawork.service.impl;

import com.pandawork.common.entity.User;
import com.pandawork.common.utils.NFException;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.core.common.util.CommonUtil;
import com.pandawork.core.framework.dao.CommonDao;
import com.pandawork.mapper.UserMapper;
import com.pandawork.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserServiceImpl
 * Created by chant on 2016/3/23.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User queryById(int id) throws SSException {
        if (Assert.lessOrEqualZero(id)){
            return null;
        }
        try {
            return userMapper.queryById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void update(User user) throws SSException {
        if (Assert.isNotNull(user)){
            return;
        }
        try {
            userMapper.update(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkLogin(String userName, String password) throws SSException {
        if (Assert.isNotNull(userName)&&Assert.isNotNull(password)){
            return false;
        }
        try {
            password = CommonUtil.md5(password);
            return userMapper.countByUserNameAndPassword(userName,password) >= 1?true:false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void delete(int id) throws SSException {

    }
}
