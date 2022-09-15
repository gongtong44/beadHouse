package com.yjy.beadhouse.service.impl;

import com.yjy.beadhouse.dao.*;
import com.yjy.beadhouse.dto.AdminCreateOrderDTO;
import com.yjy.beadhouse.entity.*;
import com.yjy.beadhouse.service.AdminService;
import com.yjy.beadhouse.vo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

import static com.yjy.beadhouse.utils.DateUtils.getNowTime;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final UserMapper userMapper;

    private final OlderMapper olderMapper;

    private final BedMapper bedMapper;

    private final NurseMapper nurseMapper;

    private final DailyMapper dailyMapper;

    private final LeaveMapper leaveMapper;

    private final TypeMapper typeMapper;

    private final OrderMapper orderMapper;

    private final MessageMapper messageMapper;

    @Override
    public String toAdminUsers(Model model) {
        List<UserVO> allUsers = userMapper.getAllUsers();
        model.addAttribute("userList",allUsers);
        return "admin-users";
    }

    @Override
    public String toModifyUser(Integer id, Model model) {
        UserVO userVoById = userMapper.getUserVoById(id);
        model.addAttribute("userInfo",userVoById);
        return "modify-user";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String modifyUser(User user) {
        userMapper.modifyUser(user);
        return "redirect:/admin-users";
    }

    @Override
    public String toAdminOlds(Model model) {
        List<OldVO> allOlds = olderMapper.getAllOlds();
        model.addAttribute("oldList",allOlds);

        return "admin-olds";
    }

    @Override
    public String toModifyOld(Integer id, Model model) {
        OldVO oldVoById = olderMapper.getOldVoById(id);
        List<Bed> freeBedList = bedMapper.getFreeBedList();
        List<User> nurseList = nurseMapper.getNurseList();
        model.addAttribute("oldInfo", oldVoById);
        model.addAttribute("bedList", freeBedList);
        model.addAttribute("nurseList",nurseList);
        return "modify-old";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String modifyOld(Older older) {
        olderMapper.modifyOld(older);
        return "redirect:/admin-olds";
    }

    @Override
    public String toAdminDaily(Model model) {
        List<DailyVO> dailyVOList = dailyMapper.getDailyVOList();
        model.addAttribute("dailyList",dailyVOList);
        return "admin-daily";
    }

    @Override
    public String dealDaily(Integer id) {
        dailyMapper.dealDaily(id);
        return "redirect:/admin-daily";
    }

    @Override
    public String delDaily(Integer id) {
        dailyMapper.delDaily(id);
        return "redirect:/admin-daily";
    }

    @Override
    public String toAdminLeave(Model model) {
        List<LeaveVO> allLeave = leaveMapper.getAllLeave();
        model.addAttribute("leaveList",allLeave);
        return "admin-leave";
    }

    @Override
    public String agreeLeave(Integer id) {
        leaveMapper.agreeLeave(id);
        return "redirect:/admin-leave";
    }

    @Override
    public String refuseLeave(Integer id) {
        leaveMapper.refuseLeave(id);
        return "redirect:/admin-leave";
    }

    @Override
    public String toAdminBed(Model model) {
        List<BedVO> allBeds = bedMapper.getAllBeds();
        model.addAttribute("bedList",allBeds);
        return "admin-bed";
    }

    @Override
    public String toAddBed(Model model) {
        List<Type> allType = typeMapper.getAllType();
        model.addAttribute("typeList",allType);
        return "add-bed";
    }

    @Override
    public String addBed(Bed bed) {
        bedMapper.addBed(bed);
        return "redirect:/admin-bed";
    }

    @Override
    public String toUpdBed(Integer id, Model model) {
        List<Type> allType = typeMapper.getAllType();
        model.addAttribute("typeList",allType);
        model.addAttribute("bedId",id);
        return "modify-bed";
    }

    @Override
    public String updateBed(Bed bed) {
        bedMapper.updateBed(bed);
        return "redirect:/admin-bed";
    }

    @Override
    public String delBed(Integer id){
        bedMapper.delBed(id);
        return "redirect:/admin-bed";
    }

    @Override
    public String toAdminMail(Model model) {
        List<Message> messageList = messageMapper.getMessageList();
        model.addAttribute("messageList",messageList);
        return "admin-mail";
    }

    @Override
    public String sendMail(Message message, HttpSession session) {
        User user_session = (User) session.getAttribute("USER_SESSION");
        message.setAddTime(getNowTime());
        message.setUserName(user_session.getName());
        messageMapper.addMessage(message);
        return "redirect:admin-message";
    }

    @Override
    public String toAdminPay(Model model) {
        List<OrderVO> allOrder = orderMapper.getAllOrder();
        List<Type> allType = typeMapper.getAllType();
        model.addAttribute("typeList",allType);
        model.addAttribute("orderList",allOrder);
        return "admin-pay";
    }

    @Override
    public String toModifyType(Model model) {
        List<Type> allType = typeMapper.getAllType();
        model.addAttribute("typeList",allType);
        return "modify-type";
    }

    @Override
    public String modifyType(Type type) {
        typeMapper.updateType(type);
        return "redirect:/admin-pay";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String createOrder(Double price) {
        List<Integer> allUserId = userMapper.getAllUserId();
        for(Integer id : allUserId){
            AdminCreateOrderDTO dto = new AdminCreateOrderDTO();
            dto.setUserId(id);
            dto.setCreateTime(getNowTime());
            dto.setPrice(price);
            orderMapper.adminCreateOrder(dto);
        }
        return "redirect:/admin-pay";
    }

    @Override
    public String toAdminNurse(Model model) {
        List<User> allNurses = nurseMapper.getNurseList();
        model.addAttribute("nurseList",allNurses);
        return "admin-nurses";
    }

    @Override
    public String toAddNurse() {
        return "add-nurse";
    }

    @Override
    public String addNurse(User user) {
        nurseMapper.addNurse(user);
        return "redirect:/admin-nurses";
    }

    @Override
    public String toModifyNurse(Integer id, Model model) {
        User nurseInfoById = nurseMapper.getNurseById(id);
        model.addAttribute("nurseInfo",nurseInfoById);
        return "modify-nurse";
    }

    @Override
    public String modifyNurse(User user) {
        nurseMapper.modifyNurse(user);
        return "redirect:/admin-nurses";
    }

    @Override
    public String delNurse(Integer id) {
        nurseMapper.delNurse(id);
        return "redirect:/admin-nurses";
    }

    @Override
    public String delOrder(Integer id) {
        orderMapper.delOrder(id);
        return "redirect:/admin-pay";
    }


}
