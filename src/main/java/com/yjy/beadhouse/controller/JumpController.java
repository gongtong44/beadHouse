package com.yjy.beadhouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class JumpController {

    @GetMapping({"/","/login"})
    public String toLogin(){
        return "login";
    }

    @GetMapping("/main")
    public String toMain(){
        return "index";
    }

    @GetMapping("/register")
    public String toRegister(){
        return "registration";
    }

    @GetMapping("/admin-main")
    public String toAdminMain(){
        return "admin-index";
    }

}
