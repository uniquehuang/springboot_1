package com.zjy.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("文件上传实体类")  //给实体类添加注释
public class Img {
    int id;

    String imgurl;
}
