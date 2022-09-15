package com.yjy.beadhouse.service.impl;


import com.yjy.beadhouse.dao.BedMapper;
import com.yjy.beadhouse.dao.DailyMapper;
import com.yjy.beadhouse.dao.LeaveMapper;
import com.yjy.beadhouse.dao.MessageMapper;
import com.yjy.beadhouse.dao.NurseMapper;
import com.yjy.beadhouse.dao.OlderMapper;
import com.yjy.beadhouse.dao.OrderMapper;
import com.yjy.beadhouse.dao.TypeMapper;
import com.yjy.beadhouse.dao.UserMapper;
import com.yjy.beadhouse.dto.AdminCreateOrderDTO;
import com.yjy.beadhouse.entity.Bed;
import com.yjy.beadhouse.entity.User;
import com.yjy.beadhouse.service.AdminService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AdminServiceImplTest {

    private final UserMapper userMapper = mock(UserMapper.class);

    private final OlderMapper olderMapper = mock(OlderMapper.class);

    private final BedMapper bedMapper = mock(BedMapper.class);

    private final NurseMapper nurseMapper = mock(NurseMapper.class);

    private final DailyMapper dailyMapper = mock(DailyMapper.class);

    private final LeaveMapper leaveMapper = mock(LeaveMapper.class);

    private final TypeMapper typeMapper = mock(TypeMapper.class);

    private final OrderMapper orderMapper = mock(OrderMapper.class);

    private final MessageMapper messageMapper = mock(MessageMapper.class);

    private final AdminService adminService = new AdminServiceImpl(userMapper, olderMapper, bedMapper, nurseMapper, dailyMapper, leaveMapper, typeMapper, orderMapper, messageMapper);

    private Model model;


    @BeforeEach
    public void setUp() {
        //given
        model = new ConcurrentModel();
    }

    @Test
    void toAdminUsersTest() {
        //given

        //when
        final String result = adminService.toAdminUsers(model);
        //then
        verify(userMapper,times(1)).getAllUsers();
        assertEquals("admin-users",result);
    }


    @Test
    void toModifyUser() {
        //given
        int id = 1;
        //when
        adminService.toModifyUser(id,model);
        //then
        verify(userMapper,times(1)).getUserVoById(id);
    }

    @Test
    void modifyUser() {
        User user = new User();
        String result = adminService.modifyUser(user);
        verify(userMapper, times(1)).modifyUser(user);
        assertEquals("redirect:/admin-users", result);
    }

    @Test
    void dealDaily() {
        int id = 1;
        String result = adminService.dealDaily(id);
        verify(dailyMapper, times(1)).dealDaily(id);
        assertEquals("redirect:/admin-daily", result);
    }

    @Test
    void delDaily() {
        int id = 1;
        String result = adminService.delDaily(id);
        verify(dailyMapper, times(1)).delDaily(id);
        assertEquals("redirect:/admin-daily", result);
    }

    @Test
    void agreeLeave(){
        int id = 1;
        String result = adminService.agreeLeave(id);
        verify(leaveMapper, times(1)).agreeLeave(id);
        assertEquals("redirect:/admin-leave", result);
    }

    @Test
    void refuseLeave() {
        int id = 1;
        String result = adminService.refuseLeave(id);
        verify(leaveMapper, times(1)).refuseLeave(id);
        assertEquals("redirect:/admin-leave", result);
    }

    @Test
    void addBed() {
        Bed bed = new Bed();
        String result = adminService.addBed(bed);
        verify(bedMapper, times(1)).addBed(bed);
        assertEquals("redirect:/admin-bed", result);
    }

    @Test
    void createOrder() {
        //given
        Double price = 1.1;
        final List<Integer> mock = List.of(1, 2, 3);
        when(userMapper.getAllUserId()).thenReturn(mock);
        //when
        final String result = adminService.createOrder(price);
        //then
        verify(orderMapper,times(3)).adminCreateOrder(any());
        assertEquals("redirect:/admin-pay",result);
    }
}
