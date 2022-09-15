package com.yjy.beadhouse.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Salary {

    private Integer id;

    private Integer nurseId;

    private Double salary;
}
