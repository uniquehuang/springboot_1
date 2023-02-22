package com.zjy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Fan
 * @since 2021-08-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel("用户实体类")  //给实体类添加注释
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String userphone;

    private String password;

    private String username;

    private Integer gender;
    @ApiModelProperty(value = "总积分")
    private Integer code;
    @ApiModelProperty(value = "被点赞数")
    private int dzcount;
    @ApiModelProperty(value = "学习打卡天数")
    private int studydayscount;
    @ApiModelProperty(value = "学习时长")
    private double studytimecount;
    @ApiModelProperty(value = "pk积分")
    private int pkcode;
    @ApiModelProperty(value = "答题积分")
    private int replycode;
    @ApiModelProperty(value = "拼图难度等级")
    private int level;
    @ApiModelProperty(value = "答对次数")
    private int drawright;
    @ApiModelProperty(value = "用户头像")
    private String userimg;
    @ApiModelProperty(value = "阅读篇数")
    private int readnumber;



}
