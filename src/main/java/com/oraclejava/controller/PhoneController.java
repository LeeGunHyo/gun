package com.oraclejava.controller;

import com.oraclejava.dao.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PhoneController {

    @Autowired
    private PhoneRepository phoneRepository;

    @GetMapping("/phoneList") //1: 주소(url)
    public ModelAndView index(ModelAndView mav){
        mav.setViewName("phone/index");//2: 뷰 네임
        mav.addObject("phoneList", //3: 모델
                phoneRepository.findAll());
        return mav;
    }

}
