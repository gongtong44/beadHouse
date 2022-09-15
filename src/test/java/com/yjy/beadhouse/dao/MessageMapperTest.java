package com.yjy.beadhouse.dao;

import com.yjy.beadhouse.entity.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @description:
 * @author: jk
 * @time: 2022/9/14 22:55
 */
@SpringBootTest
@Transactional
public class MessageMapperTest {
    @Autowired
    private MessageMapper messageMapper;

    @Test
    void getMessageList() {
        List<Message> result = messageMapper.getMessageList();
        assertEquals(3, result.size());
    }
}
