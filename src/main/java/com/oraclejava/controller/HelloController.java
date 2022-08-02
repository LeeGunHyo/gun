package com.oraclejava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
        public ModelAndView index(@RequestParam("userid") String userid,
                                  @RequestParam("pw") String pw){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        mav.addObject("msg", "감사합니다.");
        mav.addObject("userid",userid);//model 작업
        mav.addObject("pw",1234);
        return mav;
    }
}
