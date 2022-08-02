package com.oraclejava.controller;

import com.oraclejava.model.FileUpload;
import org.apache.commons.io.FileUtils;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {

    @GetMapping
    public  void setupForm(Model model){

    }

    @PostMapping("single")
    public ModelAndView doAction(@RequestParam("file")
                                 MultipartFile file,
                                 ModelAndView mav) throws IOException{
        if(!file.getOriginalFilename().isEmpty() && !file.isEmpty()){
            File uploadFile =
                    new File("e:/upload/",file.getOriginalFilename());
            file.transferTo(uploadFile);
            mav.setViewName("complete");
            mav.addObject("filename",file.getOriginalFilename());
            mav.addObject("filesize", FileUtils.byteCountToDisplaySize(file.getSize()));
            return mav;
        }else{
            mav.setViewName("fail");
            return mav;
        }
    }

    @PostMapping("multi")
    public ModelAndView doActionMulti(
            @ModelAttribute FileUpload fileUpload,
            ModelAndView mav) throws IOException {
        for (MultipartFile file : fileUpload.getFiles()){
            if(file.getOriginalFilename().isEmpty()
            || file.isEmpty()) {
                continue;
            }
            File uploadFile = new File("e:upload/",
                    file.getOriginalFilename());
            file.transferTo(uploadFile);
        }
        mav.setViewName("complete");
        return  mav;
    }
}
