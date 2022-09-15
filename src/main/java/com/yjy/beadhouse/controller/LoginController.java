package com.yjy.beadhouse.controller;

import com.yjy.beadhouse.entity.User;
import com.yjy.beadhouse.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @PostMapping("/login")
    public String loginCheck(User user, HttpSession session){
        return userService.loginCheck(user,session);
    }

    @PostMapping("/register")
    public String register(User user, HttpSession session){
        return userService.register(user,session);
    }

    @GetMapping("/logout")
    public String logOut(HttpSession session){
        session.invalidate();
        return "login";
    }

}
