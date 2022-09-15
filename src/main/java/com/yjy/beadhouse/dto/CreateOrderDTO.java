package com.yjy.beadhouse.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CreateOrderDTO {

    private Integer userId;

    private String createTime;

    private Integer bedId;
}
