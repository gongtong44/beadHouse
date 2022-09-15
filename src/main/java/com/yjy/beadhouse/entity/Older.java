package com.yjy.beadhouse.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Older {
    private Integer id;

    private String name;

    private Integer age;

    private Integer bedId;

    private Integer userId;

    private Integer nurseId;
}
