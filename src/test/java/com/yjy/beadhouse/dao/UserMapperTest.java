package com.yjy.beadhouse.dao;

import com.yjy.beadhouse.entity.User;
import com.yjy.beadhouse.vo.UserVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserMapperTest {

    public static final int ADMIN_RANK_NUMBER = 0;
    @Autowired
    private UserMapper userMapper;

    @Test
    @Sql("/sql/UserMapperTestSQL.sql")
    void getUserByName() {
        //given
        String name = "test-admin";
        //when
        final User result = userMapper.getUserByName(name);
        //then
        assertEquals(name, result.getName());
        assertEquals(ADMIN_RANK_NUMBER, result.getRank());
    }

    @Test
    @Sql("/sql/UserMapperTestSQL.sql")
    void getAllUsers() {
        List<UserVO> result = userMapper.getAllUsers();
        assertEquals(3, result.size());
    }

    @Test
    @Sql("/sql/UserMapperTestSQL.sql")
    void getUserVoById() {
        int id = 1;
        UserVO result = userMapper.getUserVoById(id);
        assertEquals(id, result.getId());
    }

    @Test
    @Sql("/sql/UserMapperTestSQL.sql")
    void userRegister() {
        //given
        final User user = new User(10001, "123", "123", "123", "123", 0);
        final int before = userMapper.getAllUsers().size();
        //when
        userMapper.userRegister(user);
        final int after = userMapper.getAllUsers().size();
        //then
        assertEquals(1, after - before);
    }
}
