package com.yjy.beadhouse.dao;

import com.yjy.beadhouse.entity.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TypeMapper {

    List<Type> getAllType();

    void updateType(Type type);
}
