package com.oraclejava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Hello2Controller {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)//1
    public ModelAndView hello(ModelAndView mav){//2

        mav.setViewName("hello");//3
        mav.addObject("userid","사용자id");
       // mav.addObject("password",password)


        return mav;
    }
}
