package com.qob.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * https://blog.csdn.net/gavin_john/article/details/79517418
 */
@Component("userService")
public class UserService {
    @Value("#{configProperties.helloUserName}")
    private String name;
    private ByeService mByeService;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Hello, " + name);
        mByeService.sayBye();
    }

    public ByeService getmByeService() {
        return mByeService;
    }

    @Autowired
    public void setmByeService(ByeService mByeService) {
        this.mByeService = mByeService;
    }
}
