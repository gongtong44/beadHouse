package com.yjy.beadhouse.service.impl;

import com.yjy.beadhouse.dao.*;
import com.yjy.beadhouse.dto.CreateOrderDTO;
import com.yjy.beadhouse.entity.*;
import com.yjy.beadhouse.service.UserService;
import com.yjy.beadhouse.vo.DailyVO;
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
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final OlderMapper olderMapper;

    private final NurseMapper nurseMapper;

    private final BedMapper bedMapper;

    private final OrderMapper orderMapper;

    private final DailyMapper dailyMapper;

    private final MessageMapper messageMapper;

    @Override
    public String loginCheck(User user, HttpSession session) {
        User userByName = userMapper.getUserByName(user.getName());
        if (userByName == null || !user.getPassword().equals(userByName.getPassword())){
            session.setAttribute("msg","用户名或密码不正确");
            return "login";
        }
        session.setAttribute("USER_SESSION",userByName);
        if (userByName.getRank() == 2 ){
            return "redirect:main";
        }else if(userByName.getRank() == 1){
            return "redirect:nurse-main";
        }else {
            return "redirect:admin-main";
        }

    }

    @Override
    public String register(User user, HttpSession session) {
        User userByName = userMapper.getUserByName(user.getName());
        if (userByName != null){
            session.setAttribute("msg","该用户名已经被注册！");
            return "registration";
        }
        userMapper.userRegister(user);
        return "login";
    }

    @Override
    public String olderInfo(HttpSession session, Model model) {
        User user_session = (User)session.getAttribute("USER_SESSION");
        Older userOlder = olderMapper.getUserOlder(user_session.getId());
        if (userOlder == null){
            model.addAttribute("msg","请先添加老人信息再进行查看！");
            return "index";
        }
        model.addAttribute("olderInfo",userOlder);
        List<DailyVO> dailyVOList = dailyMapper.getDailyVOListById(userOlder.getId());
        model.addAttribute("dailyList",dailyVOList);
        return "older-info";
    }

    @Override
    public String toAddOld(HttpSession session, Model model) {
        User user_session = (User)session.getAttribute("USER_SESSION");
        Older userOlder = olderMapper.getUserOlder(user_session.getId());
        if (userOlder != null){
            model.addAttribute("msg","您已经添加过老人，如需修改请联系管理员！");
            return "index";
        }
        List<User> nurseList = nurseMapper.getNurseList();
        model.addAttribute("nurseList",nurseList);
        List<Bed> freeBedList = bedMapper.getFreeBedList();
        model.addAttribute("freeBedList",freeBedList);
        return "addOld";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String addOld(Older older, HttpSession session, Model model) {
        Integer id = ((User) session.getAttribute("USER_SESSION")).getId();
        older.setUserId(id);
        olderMapper.addOlder(older);
        Older userOlder = olderMapper.getUserOlder(id);
        bedMapper.useFreeBed(older.getBedId(),userOlder.getId());
        CreateOrderDTO dto = new CreateOrderDTO();
        dto.setUserId(id);
        dto.setCreateTime(getNowTime());
        dto.setBedId(older.getBedId());
        orderMapper.createOrder(dto);
        model.addAttribute("msg","成功添加老人信息！");
        return "index";
    }

    @Override
    public String toUserPay(HttpSession session, Model model) {
        User user_session = (User) session.getAttribute("USER_SESSION");
        List<Order> orderByUserId = orderMapper.getOrderByUserId(user_session.getId());
        model.addAttribute("orderList",orderByUserId);
        return "userPay";
    }

    @Override
    public String userPay(Model model, Integer id) {
        orderMapper.finishOrder(getNowTime(),id);
        model.addAttribute("msg","缴费成功！");
        return "redirect:/userPay";
    }

    @Override
    public String toUserMail(Model model) {
        List<Message> messageList = messageMapper.getMessageList();
        model.addAttribute("messageList",messageList);
        return "userMail";
    }

    @Override
    public String sendMail(Message message, HttpSession session) {
        User user_session = (User) session.getAttribute("USER_SESSION");
        message.setAddTime(getNowTime());
        message.setUserName(user_session.getName());
        messageMapper.addMessage(message);
        return "redirect:userMail";
    }
}
