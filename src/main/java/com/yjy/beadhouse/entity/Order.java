package com.yjy.beadhouse.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Order {

    private Integer id;

    private Integer userId;

    private String createTime;

    private String finishTime;

    private String status;

    private Double price;
}
