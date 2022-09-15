package com.yjy.beadhouse.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Message {

    private Integer id;

    private String addTime;

    private String content;

    private String userName;

}
