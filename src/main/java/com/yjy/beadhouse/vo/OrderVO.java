package com.yjy.beadhouse.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class OrderVO {

    private Integer id;

    private String userName;

    private String createTime;

    private String finishTime;

    private String status;

    private Double price;
}
