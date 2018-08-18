package com.qob.Test;

import com.qob.Pojo.Color;
import com.qob.Service.*;
import com.qob.advice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.lang.reflect.Proxy;

import static org.testng.Assert.assertEquals;

@ContextConfiguration("classpath:applicationContext.xml")
public class HelloTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    ApplicationContext context;

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

    @Test
    public void enumTest(){
        int tCount = Color.RED.getCount();
        Color tColorType = Color.BLANK;
        switch (tColorType){
            case RED:{
                break;
            }
            case BLANK:{
                break;
            }
            case GREEN:{
                break;
            }
        }

        assertEquals(tCount, 50);
    }

    @Test
    public void testForumService(){
        TForumServiceImpl tForumService = new TForumServiceImpl();
        tForumService.removeForum(10);
        tForumService.removeTopic(1002);
    }

    @Test
    public void testFormServiceHandler(){
        TForumService target = new TForumServiceImpl();
        TPerformanceHandler handler = new TPerformanceHandler(target);
        TForumService proxy = (TForumService)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
        proxy.removeForum(10);
        proxy.removeTopic(1012);
    }

    @Test
    public void testFormServiceCGLib(){
        TCglibProxy proxy = new TCglibProxy();
        TForumServiceImpl forumService = (TForumServiceImpl)proxy.getProxy(TForumServiceImpl.class);
        forumService.removeForum(10);
        forumService.removeTopic(1023);
    }

    @Test
    public void testProxyFactoryBean(){
        Waiter waiter = (Waiter)context.getBean("waiter");
        waiter.greetTo("John");
 //       waiter.serveTo("qiaolw");
    }

    @Test
    public void testProxyTransactionManager(){
        ForumService forumService = (ForumService)context.getBean("forumService");
        try {
            forumService.removeForum(10);
        } catch (Exception e) {
            e.printStackTrace();
        }

        forumService.removeTopic(2013);
    }

    @Test
    public void testIntroduce(){
        TForumService forumService = (TForumService)context.getBean("forumService2");
        forumService.removeForum(10);
        forumService.removeTopic(1022);

        Monitorable monitorable = (Monitorable)forumService;
        monitorable.setMonitorActive(true);

        forumService.removeForum(10);
        forumService.removeTopic(1022);
    }

    @Test
    public void testStaticMethodMatcherPointcutAdvisor(){
        Waiter waiter = (Waiter)context.getBean("waiterObj");
        Seller seller = (Seller)context.getBean("sellerObj");
        waiter.greetTo("John");
        waiter.serveTo("John");
        seller.greetTo("John");
    }

    @Test
    public void testRegexMethodPointcutAdvisor(){
        Waiter waiter = (Waiter)context.getBean("waiterPf");
        waiter.greetTo("John");
        waiter.serveTo("Bob");
    }
}
