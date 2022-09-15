package com.yjy.beadhouse.dao;

import com.yjy.beadhouse.entity.Daily;
import com.yjy.beadhouse.vo.DailyVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DailyMapper {

    void addDaily(Daily daily);

    List<DailyVO> getDailyVOList();

    List<DailyVO> getDailyVOListById(Integer id);

    void dealDaily(Integer id);

    void delDaily(Integer id);




}
