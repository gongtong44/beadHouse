package com.yjy.beadhouse.dao;

import com.yjy.beadhouse.vo.DailyVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @description:
 * @author: jk
 * @time: 2022/9/14 22:29
 */
@Transactional
@SpringBootTest
public class DaliyMapperTest {
    @Autowired
    private DailyMapper dailyMapper;

    @Test
    void getDailyVOList() {
        final List<DailyVO> result = dailyMapper.getDailyVOList();
        assertEquals(4, result.size());
    }

    @Test
    void getDailyVOListById() {
        int id = 1;
        List<DailyVO> result = dailyMapper.getDailyVOListById(id);
        assertEquals(0, result.size());
    }
}
