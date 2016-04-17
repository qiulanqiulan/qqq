package com.pandawork.service;

import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * UserService
 * Created by chant on 2016/3/23.
 */
public interface UserService {
    /**
     * 根据id查User
     * @param id
     * @return
     * @throws SSException
     */
    public User queryById(int id) throws SSException;
    /**
     * 更新
     * @param user
     * @throws SSException
     */
    public void update(User user) throws SSException;

    /**
     * 检查登录
     * @param userName
     * @param password
     * @return
     * @throws SSException
     */
    public boolean checkLogin(String userName,String password) throws SSException;
    /**
     * 删除
     */
    public void delete(int id)throws SSException;
}
