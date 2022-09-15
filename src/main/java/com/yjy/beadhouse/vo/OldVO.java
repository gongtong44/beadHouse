package com.yjy.beadhouse.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class OldVO {

    private Integer id;

    private String name;

    private Integer age;

    private String bedName;

    private String userName;

    private Integer bedId;

    private String nurseName;

}
