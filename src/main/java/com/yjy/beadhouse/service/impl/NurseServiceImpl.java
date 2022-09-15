package com.yjy.beadhouse.service.impl;

import com.yjy.beadhouse.dao.DailyMapper;
import com.yjy.beadhouse.dao.LeaveMapper;
import com.yjy.beadhouse.dao.OlderMapper;
import com.yjy.beadhouse.dao.SalaryMapper;
import com.yjy.beadhouse.entity.*;
import com.yjy.beadhouse.service.NurseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import static com.yjy.beadhouse.utils.DateUtils.getNowTime;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NurseServiceImpl implements NurseService {

    private final OlderMapper olderMapper;

    private final DailyMapper dailyMapper;

    private final LeaveMapper leaveMapper;

    private final SalaryMapper salaryMapper;

    @Override
    public String toNurseOlds(HttpSession session, Model model) {
        Integer id = ((User) session.getAttribute("USER_SESSION")).getId();
        List<Older> nurseOlderList = olderMapper.getNurseOlderList(id);
        model.addAttribute("oldList", nurseOlderList);
        return "nurse-olds";
    }

    @Override
    public String toNurseLeave(HttpSession session, Model model) {
        Integer id = ((User)session.getAttribute("USER_SESSION")).getId();
        List<Leave> leaveList = leaveMapper.getNurseLeaveList(id);
        model.addAttribute("leaveList", leaveList);
        return "nurse-leave";
    }

    @Override
    public String toUploadDaily(Integer id, Model model) {
        Older olderById = olderMapper.getOlderById(id);
        model.addAttribute("old",olderById);
        return "upload-daily";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String uploadDaily(Daily daily, HttpSession session) {
        Integer id = ((User) session.getAttribute("USER_SESSION")).getId();
        daily.setNurseId(id);
        daily.setAddTime(getNowTime());
        dailyMapper.addDaily(daily);
        return "redirect:/nurse-olds";
    }

    @Override
    public String addLeave(Leave leave, HttpSession session) {
        Integer id = ((User) session.getAttribute("USER_SESSION")).getId();
        leave.setNurseId(id);
        leaveMapper.addLeave(leave);
        return "redirect:/nurse-leave";
    }

    @Override
    public String toNurseMain(HttpSession session, Model model) {
        Integer id = ((User) session.getAttribute("USER_SESSION")).getId();
        Salary salaryById = salaryMapper.getSalaryById(id);
        model.addAttribute("salary",salaryById);
        return "nurse-index";
    }
}
