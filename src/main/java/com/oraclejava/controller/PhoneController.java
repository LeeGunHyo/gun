package com.oraclejava.controller;

import com.oraclejava.dao.PhoneRepository;
import com.oraclejava.model.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PhoneController {

    @Autowired
    private PhoneRepository phoneRepository;

    private static final int PAGE_SIZE = 2;

    @GetMapping("/phoneList") //1: 주소(url)
    public ModelAndView index(@RequestParam(required = false) Integer pageNumber,
                              ModelAndView mav) {
        pageNumber = (pageNumber == null) ? 1 : pageNumber;

        Page<Phone> phones =
                phoneRepository.findAll(PageRequest.of(pageNumber - 1,
                        PAGE_SIZE, Sort.by("name").ascending()));
        int current = phones.getNumber() + 1;
        int begin = 1;
        int end = phones.getTotalPages();

        mav.setViewName("phone/index");//2: 뷰 네임
        mav.addObject("phoneList", phones);
        mav.addObject("beginIndex", begin);
        mav.addObject("endIndex", end);
        mav.addObject("currentIndex", current);

        return mav;
    }

    //폰 추가
    @GetMapping("/phone/create")
    public String create(Model model) {
        return "/phone/create";
    }

    @PostMapping("/phone/create")
    public String create(Phone phone, Model model) {
        phoneRepository.save(phone);
        return "redirect:/phoneList";
    }

    //폰 수정
    @GetMapping("/phone/update/{id}")
    public String update(@PathVariable Integer id, Model model) {
        Phone phone = phoneRepository.findById(id).get();
        model.addAttribute("phone", phone);
        return "phone/update";
    }


    @PostMapping(value = "/phone/update/{id}",params = "update")
    public String update(Phone phone, Model model) {
        Phone sphone = phoneRepository.findById(phone.getId()).get();
        sphone.setName(phone.getName());
        sphone.setPrice(phone.getPrice());
        phoneRepository.save(sphone);
        return "redirect:/phoneList";
    }
    //삭제
    @RequestMapping(params = "delete",value = "/phone/update/{id}",
            method = RequestMethod.POST)
    public String delete(@PathVariable Integer id,Model model){
        Phone sphone = phoneRepository.findById(id).get();
        phoneRepository.delete(sphone);
        return "redirect:/phoneList";
    }

}

