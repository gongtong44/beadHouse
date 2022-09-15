package com.yjy.beadhouse.dao;

import com.yjy.beadhouse.entity.Salary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @description:
 * @author: jk
 * @time: 2022/9/14 23:01
 */
@Transactional
@SpringBootTest
public class SalaryMapperTest {
    @Autowired
    private SalaryMapper salaryMapper;

    @Test
    @Sql("/sql/SalaryMapperTestSQL.sql")
    void getSalaryById() {
        int id = 100000000;

        Salary result = salaryMapper.getSalaryById(id);
        assertEquals(id, result.getNurseId());
    }
}
