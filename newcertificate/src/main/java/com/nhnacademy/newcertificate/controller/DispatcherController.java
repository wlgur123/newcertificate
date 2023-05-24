package com.nhnacademy.newcertificate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class DispatcherController {

    //시작페이지(주민인증)
    @GetMapping("/")
    public String home(){
        return "home/loginPage";
    }


//    @GetMapping("/")
//    public String home(){
//        return "home/home";
//    }


}
