package com.zjy.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@ApiModel("更新用户积分实体类")  //给实体类添加注释
public class UserTotalCode {

    @NotNull(message = "返回的用户id不能为空")
    private Integer id;

    @ApiModelProperty(value = "总积分")
    private Integer code;

    @ApiModelProperty(value = "pk积分")
    private int pkcode;
    @ApiModelProperty(value = "答题积分")
    private int replycode;
    @ApiModelProperty(value = "拼图难度等级")
    private int level;
    @ApiModelProperty(value = "答对次数")
    private int drawright;
    @ApiModelProperty(value = "学习打卡天数")
    private int studydayscount;
    @ApiModelProperty(value = "被点赞数")
    private int dzcount;
}
