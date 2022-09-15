package com.yjy.beadhouse.service;

import com.yjy.beadhouse.entity.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

public interface AdminService {

    String toAdminUsers(Model model);

    String toModifyUser(Integer id, Model model);

    String modifyUser(User user);

    String toAdminOlds(Model model);

    String toModifyOld(Integer id, Model model);

    String modifyOld(Older older);

    String toAdminDaily(Model model);

    String dealDaily(Integer id);

    String delDaily(Integer id);

    String toAdminLeave(Model model);

    String agreeLeave(Integer id);

    String refuseLeave(Integer id);

    String toAdminBed(Model model);

    String toAddBed(Model model);

    String addBed(Bed bed);

    String toUpdBed(Integer id, Model model);

    String updateBed(Bed bed);

    String delBed(Integer id);

    String toAdminMail(Model model);

    String sendMail(Message message, HttpSession session);

    String toAdminPay(Model model);

    String toModifyType(Model model);

    String modifyType(Type type);

    String createOrder(Double price);

    String toAdminNurse(Model model);

    String toAddNurse();

    String addNurse(User user);

    String toModifyNurse(Integer id, Model model);

    String modifyNurse(User user);

    String delNurse(Integer id);

    String delOrder(Integer id);
}
