package com.yjy.beadhouse.dao;

import com.yjy.beadhouse.entity.User;
import com.yjy.beadhouse.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User getUserByName(String name);

    void userRegister(User user);

    List<UserVO> getAllUsers();

    UserVO getUserVoById(Integer id);

    void modifyUser(User user);

    List<Integer> getAllUserId();


}
