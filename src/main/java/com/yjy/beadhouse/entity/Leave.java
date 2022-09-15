package com.yjy.beadhouse.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Leave {

    private Integer id;

    private Integer nurseId;

    private String startDate;

    private String endDate;

    private String reason;

    private String status;
}
