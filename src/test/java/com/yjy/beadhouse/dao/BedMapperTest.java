package com.yjy.beadhouse.dao;

import com.yjy.beadhouse.entity.Bed;

import com.yjy.beadhouse.vo.BedVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author: jk
 * @time: 2022/9/14 21:55
 */

@SpringBootTest
@Transactional
public class BedMapperTest {
    @Autowired
    private BedMapper bedMapper;

    @Test
    @Sql("/sql/BedMapperTestSQL.sql")
    void getFreeBedList() {
        final List<Bed> result = bedMapper.getFreeBedList();

        assertEquals(7, result.size());
    }

    @Test
    @Sql("/sql/BedMapperTestSQL.sql")
    void getAllBeds() {
        final List<BedVO> result = bedMapper.getAllBeds();
        assertEquals(11, result.size());
    }
}
