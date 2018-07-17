package com.qob;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloTest {

    @RequestMapping("/ok")
    public void okTest(){
        System.out.println("okTest");
    }
}
