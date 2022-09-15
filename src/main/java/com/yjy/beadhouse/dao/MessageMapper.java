package com.yjy.beadhouse.dao;

import com.yjy.beadhouse.entity.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageMapper {

    List<Message> getMessageList();

    void addMessage(Message message);
}
