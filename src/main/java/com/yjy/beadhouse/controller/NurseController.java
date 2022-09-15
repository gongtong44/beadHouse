package com.yjy.beadhouse.controller;

import com.yjy.beadhouse.entity.Daily;
import com.yjy.beadhouse.entity.Leave;
import com.yjy.beadhouse.service.NurseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class NurseController {


    private final NurseService nurseService;

    @GetMapping("/nurse-olds")
    public String toNurseOlds(HttpSession session, Model model){
        return nurseService.toNurseOlds(session, model);
    }

    @GetMapping("/upload/{id}")
    public String toUploadDaily(@PathVariable("id")Integer id,Model model){
        return nurseService.toUploadDaily(id, model);
    }

    @PostMapping("/upload-daily")
    public String uploadDaily(Daily daily,HttpSession session){
        return nurseService.uploadDaily(daily,session);
    }

    @GetMapping("/nurse-leave")
    public String toNurseLeave(HttpSession session, Model model){
        return nurseService.toNurseLeave(session, model);
    }

    @GetMapping("/leave")
    public String toAddLeave(){
        return "add-leave";
    }

    @PostMapping("/leave")
    public String addLeave(Leave leave,HttpSession session){
        return nurseService.addLeave(leave, session);
    }

    @GetMapping("/nurse-main")
    public String toNurseMain(HttpSession session, Model model){
        return nurseService.toNurseMain(session, model);
    }


}
