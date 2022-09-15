package com.yjy.beadhouse.dao;

import com.yjy.beadhouse.entity.Salary;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SalaryMapper {

    Salary getSalaryById(Integer id);
}
