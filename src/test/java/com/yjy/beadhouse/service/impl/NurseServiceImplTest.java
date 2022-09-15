package com.yjy.beadhouse.service.impl;

import com.yjy.beadhouse.dao.DailyMapper;
import com.yjy.beadhouse.dao.LeaveMapper;
import com.yjy.beadhouse.dao.OlderMapper;
import com.yjy.beadhouse.dao.SalaryMapper;
import com.yjy.beadhouse.service.NurseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
/**
 * @description:
 * @author: jk
 * @time: 2022/9/14 20:56
 */
public class NurseServiceImplTest {
    private final OlderMapper olderMapper = mock(OlderMapper.class);

    private final DailyMapper dailyMapper = mock(DailyMapper.class);

    private final  LeaveMapper leaveMapper = mock(LeaveMapper.class);

    private final SalaryMapper salaryMapper = mock(SalaryMapper.class);

    private final NurseService nurseService = new NurseServiceImpl(olderMapper, dailyMapper, leaveMapper, salaryMapper);

    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ConcurrentModel();
    }

    @Test
    void toUploadDaily() {
        int id = 1;
        String result = nurseService.toUploadDaily(id, model);
        verify(olderMapper, times(1)).getOlderById(id);
        assertEquals("upload-daily", result);

    }

}
