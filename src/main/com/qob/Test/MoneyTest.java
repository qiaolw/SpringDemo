package com.qob.Test;

import com.qob.Pojo.TMoney;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class MoneyTest {
    private TMoney f12CHF;  //12 瑞士法郎
    private TMoney f14CHF;  //14 瑞士法郎
    private TMoney f28USD;  //28 美国美元
    private TMoney user;

    @BeforeClass
    public void init(){
        System.out.println("init()");
        user = null;
    }

    @BeforeMethod
    protected void setUp(){
        System.out.println("setUp()");
        f12CHF = new TMoney(12, "CHF");
        f14CHF = new TMoney(14, "CHF");
        f28USD = new TMoney(28, "USD");
    }

    @Test
    public void moneyBag(){
        TMoney bag[] = {f14CHF, f28USD};
        assertEquals("aaa", "bbb");
    }

    @Test(enabled = true, expectedExceptions = NullPointerException.class)
    public void testUser(){
        assertNotNull(user.getArg2());
    }

    @AfterMethod
    protected void tearDown(){
        System.out.println("tearDown()");
    }
}
