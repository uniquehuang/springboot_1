package com.zjy.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel("文艺作品实体类")
public class WorkPart {

    private Integer id;

    private String imgurl;

    private String title;

    private String author;

    private String category;

    private String sort;
}
