package com.qob.Test;

import com.qob.Service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class TUserServiceTest {
    private TUserService userService;

    @Autowired
    public void setUserService(TUserService userService) {
        this.userService = userService;
    }

    public void hasMatchUser(){
        boolean b1 = userService.hasMatchUser("admin", "123456");
        boolean b2 = userService.hasMatchUser("admin", "1111");

    }
}
