package com.zjy.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel("红色人物实体类")  //给实体类添加注释
public class PersonPart {
    private Integer id;

    private String title;

    private String age;

    private String text;

    private String imgurl;

    private String sort;
}
