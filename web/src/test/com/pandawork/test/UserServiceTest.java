package com.pandawork.test;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by chant on 2016/3/26.
 */
public class UserServiceTest extends AbstractTestCase {
    @Autowired
    UserService userService;

    @Test
    public void testQueryById() throws SSException{
        System.out.println(userService.queryById(1).getUserName());
    }
}
