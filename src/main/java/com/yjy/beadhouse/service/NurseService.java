package com.yjy.beadhouse.service;

import com.yjy.beadhouse.entity.Daily;
import com.yjy.beadhouse.entity.Leave;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

public interface NurseService {

    String toNurseOlds(HttpSession session, Model model);

    String toNurseLeave(HttpSession session, Model model);

    String toUploadDaily(Integer id, Model model);

    String uploadDaily(Daily daily,HttpSession session);

    String addLeave(Leave leave, HttpSession session);

    String toNurseMain(HttpSession session, Model model);
}
