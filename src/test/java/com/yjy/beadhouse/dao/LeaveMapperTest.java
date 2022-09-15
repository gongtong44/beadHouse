package com.yjy.beadhouse.dao;

import com.yjy.beadhouse.entity.Leave;
import com.yjy.beadhouse.vo.LeaveVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @description:
 * @author: jk
 * @time: 2022/9/14 22:50
 */
@SpringBootTest
@Transactional
public class LeaveMapperTest {
    @Autowired
    private LeaveMapper leaveMapper;

    @Test
    void getNurseLeaveList() {
        int id = 2;
        List<Leave> result = leaveMapper.getNurseLeaveList(id);
        assertEquals(1, result.size());
    }

    @Test
    void getAllLeave() {
        List<LeaveVO> result = leaveMapper.getAllLeave();
        assertEquals(1, result.size());
    }





}
