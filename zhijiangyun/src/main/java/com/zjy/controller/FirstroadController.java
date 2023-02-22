package com.zjy.controller;


import com.zjy.entity.Firstroad;
import com.zjy.entity.Literature;
import com.zjy.service.FirstroadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Fan
 * @since 2021-08-12
 */
@RestController
@RequestMapping("/firstroad")
@Api(tags = "红色精神之旅坐标接口")
public class FirstroadController {
    @Autowired
    FirstroadService firstroadService;

    @ApiOperation(value = "获取第一条路的坐标信息")
    @GetMapping("/getFirstRoad")
    public Result getFirstRoad(){
        List<Firstroad> firstroadList = firstroadService.list();
        return Result.success(firstroadList);
    }

}
