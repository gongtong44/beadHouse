package com.yjy.beadhouse.dao;

import com.yjy.beadhouse.entity.Leave;
import com.yjy.beadhouse.vo.LeaveVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LeaveMapper {


    List<Leave> getNurseLeaveList(Integer id);

    void addLeave(Leave leave);

    List<LeaveVO> getAllLeave();

    void agreeLeave(Integer id);

    void refuseLeave(Integer id);
}
