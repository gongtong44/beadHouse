package com.yjy.beadhouse.controller;

import com.yjy.beadhouse.entity.*;
import com.yjy.beadhouse.service.AdminService;
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
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/admin-users")
    public String toAdminUsers(Model model){
        return adminService.toAdminUsers(model);
    }

    @GetMapping("/modify-user/{id}")
    public String toModifyUser(@PathVariable("id") Integer id,Model model){
        return adminService.toModifyUser(id,model);
    }

    @PostMapping("/modify-user")
    public String modifyUser(User user){
        return adminService.modifyUser(user);
    }

    @GetMapping("/admin-olds")
    public String toAdminOlds(Model model){
        return adminService.toAdminOlds(model) ;
    }

    @GetMapping("/modify-old/{id}")
    public String toModifyOld(@PathVariable("id") Integer id, Model model){
        return adminService.toModifyOld(id, model);
    }

    @PostMapping("/modify-old")
    public String modifyOld(Older older){
        return adminService.modifyOld(older);
    }

    @GetMapping("/admin-daily")
    public String toAdminDaily(Model model){
        return adminService.toAdminDaily(model);
    }

    @GetMapping("/daily-deal/{id}")
    public String dealDaily(@PathVariable("id") Integer id){
        return adminService.dealDaily(id);
    }

    @GetMapping("/daily-del/{id}")
    public String delDaily(@PathVariable("id") Integer id){
        return adminService.delDaily(id);
    }

    @GetMapping("/admin-leave")
    public String toAdminLeave(Model model){
        return adminService.toAdminLeave(model);
    }

    @GetMapping("/leave-agree/{id}")
    public String agreeLeave(@PathVariable("id") Integer id){
        return adminService.agreeLeave(id);
    }

    @GetMapping("/leave-refuse/{id}")
    public String refuseLeave(@PathVariable("id") Integer id){
        return adminService.refuseLeave(id);
    }

    @GetMapping("/admin-bed")
    public String toAdminBed(Model model){
        return adminService.toAdminBed(model);
    }

    @GetMapping("/add-bed")
    public String toAddBed(Model model){
        return adminService.toAddBed(model);
    }

    @PostMapping("/add-bed")
    public String addBed(Bed bed){
        return adminService.addBed(bed);
    }

    @GetMapping("/upd-bed/{id}")
    public String toUpdBed(@PathVariable("id")Integer id, Model model){
        return adminService.toUpdBed(id, model);
    }

    @PostMapping("/upd-bed")
    public String updateBed(Bed bed){
        return adminService.updateBed(bed);
    }

    @GetMapping("/del-bed/{id}")
    public String delBed(@PathVariable("id") Integer id){
        return adminService.delBed(id);
    }

    @GetMapping("/admin-message")
    public String toAdminMail(Model model){
        return adminService.toAdminMail(model);
    }

    @PostMapping("/admin-mail")
    public String sendMail(Message message, HttpSession session){
        return adminService.sendMail(message,session);
    }

    @GetMapping("/admin-pay")
    public String toAdminPay(Model model){
        return adminService.toAdminPay(model);
    }

    @GetMapping("/modify-type")
    public String toModifyType(Model model){
        return adminService.toModifyType(model);
    }

    @PostMapping("/modify-type")
    public String modifyType(Type type){
        return adminService.modifyType(type);
    }

    @GetMapping("/admin-order")
    public String toCreateOrder(){
        return "admin-order";
    }

    @PostMapping("/admin-order")
    public String createOrder(Double price){
        return adminService.createOrder(price);
    }

    @GetMapping("/admin-nurses")
    public String toAdminNurse(Model model){
        return adminService.toAdminNurse(model);
    }

    @GetMapping("/add-nurse")
    public String toAddNurse(){
        return adminService.toAddNurse();
    }

    @PostMapping("/add-nurse")
    public String addNurse(User user){
        return adminService.addNurse(user);
    }

    @GetMapping("/modify-nurse/{id}")
    public String toModifyNurse(@PathVariable("id")Integer id, Model model){
        return adminService.toModifyNurse(id, model);
    }

    @PostMapping("/modify-nurse")
    public String modifyNurse(User user){
        return adminService.modifyNurse(user);
    }

    @GetMapping("/del-nurse/{id}")
    public String delNurse(@PathVariable("id") Integer id){
        return adminService.delNurse(id);
    }

    @GetMapping("/del-order/{id}")
    public String delOrder(@PathVariable("id") Integer id) {
        return adminService.delOrder(id);
    }


}
