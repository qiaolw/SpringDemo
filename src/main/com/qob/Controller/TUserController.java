package com.qob.Controller;

import com.qob.Pojo.TUser;
import com.qob.Service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class TUserController {

    @RequestMapping("/register")
    public String register(){
        return "user/register";
    }

    @RequestMapping(method= RequestMethod.POST)
    public ModelAndView createUser(){

        ModelAndView mav = new ModelAndView();
        mav.setViewName("user/createSuccess");
        mav.addObject("userName", "qob");

        return mav;
    }
}
