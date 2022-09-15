package com.yjy.beadhouse.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DailyVO {

    private Integer id;

    private String addTime;

    private String content;

    private String oldName;

    private String nurseName;

    private String status;

}
