package com.zjy.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjy.entity.Scenery;
import com.zjy.entity.Video;
import com.zjy.service.SceneryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Fan
 * @since 2021-08-26
 */
@RestController
@RequestMapping("/scenery")
@Api(tags = "获取景点接口")
public class SceneryController {
    @Autowired
    SceneryService sceneryService;

    @ApiOperation(value = "根据title获取景点")
    @GetMapping("/getSceneryByTitle")
    public Result getSceneryByTitle(@RequestParam(required = true) String title){
        Scenery scenery = sceneryService.getOne(new QueryWrapper<Scenery>().eq("title", title));
        Assert.notNull(scenery,"该视频不存在");
        return Result.success(scenery);
    }

}
