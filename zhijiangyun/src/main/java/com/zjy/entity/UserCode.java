package com.zjy.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("用户积分实体类")
public class UserCode {

    private String username;

    private Integer code;

    private Integer gender;

    private String userimg;

}
