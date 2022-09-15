package com.yjy.beadhouse.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Bed {
    private Integer id;

    private Integer typeId;

    private String name;

    private Integer oldId;

    private String status;
}
