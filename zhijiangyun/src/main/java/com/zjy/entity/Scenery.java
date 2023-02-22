package com.zjy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Fan
 * @since 2021-08-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Scenery implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String title;

    private String imgurl;

    private String simgurl;

    private String sortimgurl;

    private String sceneryinfo;

    private String arurl;

    private String aboutinfo;

    private String aboutimgurl;

    private String personname;

    private String personimg;

    private String comment;

    private String apersonname;

    private String apersonimg;

    private String acomment;

    private String cityid;


}
