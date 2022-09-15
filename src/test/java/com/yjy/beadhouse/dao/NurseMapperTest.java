package com.yjy.beadhouse.dao;

import com.yjy.beadhouse.entity.User;
import lombok.experimental.Accessors;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @description:
 * @author: jk
 * @time: 2022/9/14 22:57
 */
@SpringBootTest
@Transactional
public class NurseMapperTest {
    @Autowired
    private NurseMapper nurseMapper;

    @Test
    void getNurseList() {
        List<User> result = nurseMapper.getNurseList();
        assertEquals(3, result.size());
    }

    @Test
    void getNurseById() {
        int id = 2;
        User result = nurseMapper.getNurseById(id);
        assertEquals(id, result.getId());
    }

}
