package com.yjy.beadhouse.service;

import com.yjy.beadhouse.entity.Message;
import com.yjy.beadhouse.entity.Older;
import com.yjy.beadhouse.entity.User;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface UserService {

    String loginCheck(User user, HttpSession session);

    String register(User user, HttpSession session);

    String olderInfo(HttpSession session, Model model);

    String toAddOld(HttpSession session, Model model);

    String addOld(Older older, HttpSession session, Model model);

    String toUserPay(HttpSession session, Model model);

    String userPay(Model model, Integer id);

    String toUserMail(Model model);

    String sendMail(Message message, HttpSession session);
}
