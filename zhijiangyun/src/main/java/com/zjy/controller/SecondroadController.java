package com.zjy.controller;


import com.zjy.entity.Firstroad;
import com.zjy.entity.Secondroad;
import com.zjy.service.SecondroadService;
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
@RequestMapping("/secondroad")
@Api(tags = "红色信仰之旅坐标接口")
public class SecondroadController {
    @Autowired
    SecondroadService secondroadService;

    @ApiOperation(value = "获取第二条路的坐标信息")
    @GetMapping("/getSecondRoad")
    public Result getSecondRoad(){
        List<Secondroad> secondroadList = secondroadService.list();
        return Result.success(secondroadList);
    }

}
