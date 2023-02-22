package com.zjy.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@ApiModel("注册用户实体类")  //给实体类添加注释
@Data
public class RegisterUser {

    @ApiModelProperty(value = "手机号，非空")
    @NotBlank(message = "手机号不能为空")
    private String userphone;
    @ApiModelProperty(value = "密码，非空")
    @NotBlank(message = "密码不能为空")
    private String password;
    @ApiModelProperty(value = "用户名，不填默认为null")
    private String username;
    @ApiModelProperty(value = "性别，男1女0")
    private Integer gender;
}
