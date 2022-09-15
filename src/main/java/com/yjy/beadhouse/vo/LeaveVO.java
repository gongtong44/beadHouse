package com.yjy.beadhouse.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LeaveVO {

    private Integer id;

    private String nurseName;

    private String startDate;

    private String endDate;

    private String reason;

    private String status;

}
