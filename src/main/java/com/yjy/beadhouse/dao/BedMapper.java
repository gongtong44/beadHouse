package com.yjy.beadhouse.dao;

import com.yjy.beadhouse.entity.Bed;
import com.yjy.beadhouse.vo.BedVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BedMapper {

    List<Bed> getFreeBedList();

    void useFreeBed(@Param("id") Integer id, @Param("olderId")Integer olderId);

    List<BedVO> getAllBeds();

    void addBed(Bed bed);

    void updateBed(Bed bed);

    void delBed(Integer id);
}
