package com.oraclejava.controller;

import com.oraclejava.model.SignUpForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignUpController {

    @PostMapping("/signUp")
    public ModelAndView postSignUp(
            @ModelAttribute SignUpForm form,
            ModelAndView mav){
        mav.setViewName("signUp_result");
        mav.addObject("form",form);

        return mav;
    }
}
