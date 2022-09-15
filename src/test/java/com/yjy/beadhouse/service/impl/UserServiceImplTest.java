package com.yjy.beadhouse.service.impl;

import com.yjy.beadhouse.dao.*;
import com.yjy.beadhouse.entity.Message;
import com.yjy.beadhouse.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import java.util.List;

import static com.yjy.beadhouse.utils.DateUtils.getNowTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
/**
 * @description:
 * @author: jk
 * @time: 2022/9/14 21:31
 */
public class UserServiceImplTest {
    private final UserMapper userMapper = mock(UserMapper.class);

    private final OlderMapper olderMapper = mock(OlderMapper.class);

    private final NurseMapper nurseMapper = mock(NurseMapper.class);

    private final BedMapper bedMapper = mock(BedMapper.class);

    private final OrderMapper orderMapper = mock(OrderMapper.class);

    private final DailyMapper dailyMapper = mock(DailyMapper.class);

    private final MessageMapper messageMapper = mock(MessageMapper.class);

    private final UserService userService = new UserServiceImpl(userMapper, olderMapper, nurseMapper, bedMapper, orderMapper, dailyMapper, messageMapper);

    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ConcurrentModel();
    }

    @Test
    void userPay() {
        int id = 1;
        final String result = userService.userPay(model, id);
        verify(orderMapper, times(1)).finishOrder(getNowTime(),id);
        assertEquals("redirect:/userPay", result);
    }

    @Test
    void toUserMail() {
        final List<Message> mock = List.of(new Message(), new Message());
        when(messageMapper.getMessageList()).thenReturn(mock);
        final String result = userService.toUserMail(model);
        verify(messageMapper,times(1)).getMessageList();
        assertEquals("userMail", result);
    }





}
