package com.zjy.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
@ApiModel("登录用户实体类")  //给实体类添加注释
public class Userlogin {
    @ApiModelProperty(value = "登录时手机号，非空")
    @NotBlank(message = "手机号不能为空")
    private String userphone;
    @ApiModelProperty(value = "登录时密码，非空")
    @NotBlank(message = "密码不能为空")
    private String password;
}
