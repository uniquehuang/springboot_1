package com.zjy.entity;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@ApiModel("更新视频实体类")
public class VideoLike {

    @NotNull(message = "视频id不能为空")
    private Integer id;

    private Integer dzcount;

    private Integer collectcount;

    private Integer commentcount;

    private Integer dzflag;

    private Integer scflag;
}
