package com.yjy.beadhouse.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BedVO {

    private Integer id;

    private String name;

    private  String typeId;

    private String oldId;

    private String status;

    private String oldName;
}
