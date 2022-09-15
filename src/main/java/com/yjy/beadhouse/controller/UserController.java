package com.yjy.beadhouse.controller;

import com.yjy.beadhouse.entity.Message;
import com.yjy.beadhouse.entity.Older;
import com.yjy.beadhouse.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/oldInfo")
    public String getOlderInfo(HttpSession session, Model model){
        return userService.olderInfo(session,model);
    }

    @GetMapping("/old")
    public String toAddOld(HttpSession session, Model model){
        return userService.toAddOld(session,model);
    }

    @PostMapping("/old")
    public String addOld(Older older, HttpSession session, Model model){
        return userService.addOld(older, session, model);
    }

    @GetMapping("/userPay")
    public String toUserPay(HttpSession session, Model model){
        return userService.toUserPay(session, model);
    }

    @GetMapping("/pay/{id}")
    public String userPay(Model model, @PathVariable("id")Integer id){
        return userService.userPay(model, id);
    }

    @GetMapping("/userMail")
    public String toUserMail(Model model){
        return userService.toUserMail(model);
    }

    @PostMapping("/mail")
    public String sendMail(Message message, HttpSession session){
        return userService.sendMail(message,session);
    }


}
