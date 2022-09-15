package com.yjy.beadhouse.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AdminCreateOrderDTO {

    private Integer userId;

    private String createTime;

    private Double price;
}
