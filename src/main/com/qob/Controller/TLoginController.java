package com.qob.Controller;

import com.qob.Pojo.TUser;
import com.qob.Service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
public class TLoginController {
    private TUserService userService;

    @Autowired
    public void setUserService(TUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/index.html")
    public String loginPage(){
        return "hello";
    }

    @RequestMapping(value = "/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request, HttpServletResponse response){

        String tUserName = request.getParameter("userName");
        String tUserPwd = request.getParameter("password");
        boolean isValidUser = userService.hasMatchUser(tUserName, tUserPwd);
        if (!isValidUser){
            return new ModelAndView("hello", "error", "用户名或密码错误");
        }
        else {
            TUser user = userService.findUserByUserName(tUserName);
            user.setLastIp(request.getLocalAddr());
            user.setLastVisit(new Date());
            userService.loginSuccess(user);

            request.getSession().setAttribute("user", user);

            return new ModelAndView("main");
        }
    }
}
