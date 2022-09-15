package com.yjy.beadhouse.dao;

import com.yjy.beadhouse.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NurseMapper {

    List<User> getNurseList();

    void addNurse(User user);

    User getNurseById(Integer id);

    void modifyNurse(User user);

    void delNurse(Integer id);
}
