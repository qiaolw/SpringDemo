package com.qob.Test;

import com.qob.Service.TMoAttack;
import com.qob.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration("classpath:applicationContext.xml")
public class HelloTest extends AbstractTransactionalTestNGSpringContextTests {

    private UserService userService;
    @Autowired
    private TMoAttack mMoAttack;

    public UserService getUserService() {
        return userService;
    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void testSayHello(){
        if (userService != null) {
            userService.sayHello();
        }
        else {
            System.out.println("userService == null");
        }
    }

    @Test
    public void testGeli(){
        mMoAttack.cityGateAsk();
    }
}
