package com.yjy.beadhouse.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserVO {

    private Integer id;

    private String name;

    private String password;

    private String mobile;

    private String email;

    private String rank;
}
