package com.zjy.entity;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel("红色事迹实体类")  //给实体类添加注释
public class EventPart {

    private Integer id;

    private String imgurl;

    private String title;

    private String category;

    private String place;


}
