package com.qob.Test;

import com.qob.Pojo.TUser;
import com.qob.Service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TUserServiceTest{
    private TUserService userService;

    @Autowired
    public void setUserService(TUserService userService) {
        this.userService = userService;
    }

    @Test
    public void hasMatchUser(){
        boolean b1 = userService.hasMatchUser("admin", "123456");
        boolean b2 = userService.hasMatchUser("admin", "1111");
        assertTrue(b1);
        assertTrue(b2);
    }

    @Test
    public void findUserByUserName(){
        TUser user = userService.findUserByUserName("admin");
        assertEquals(user.getUserName(), "admin");
    }
}
