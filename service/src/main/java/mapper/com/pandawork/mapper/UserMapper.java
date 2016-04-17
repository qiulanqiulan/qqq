package com.pandawork.mapper;

import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/*
 **
 * UserMapper
 *  Created by chant on 2016/3/23.
 */
public interface UserMapper {
    /**
     * 根据id查User
     * @param id
     * @return
     * @throws Exception
     */
    public User queryById(int id) throws Exception;

    /**
     * 更新
     * @param user
     * @throws Exception
     */
    public void update(User user) throws Exception;

    /**
     * 判断数据库里面符合条件的数据
     * @param userName
     * @param password
     * @return
     * @throws Exception
     */
    public int countByUserNameAndPassword(String userName,String password) throws Exception;
}
