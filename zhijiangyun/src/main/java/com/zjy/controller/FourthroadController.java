package com.zjy.controller;


import com.zjy.entity.Fourthroad;
import com.zjy.entity.Secondroad;
import com.zjy.service.FourthroadService;
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
@RequestMapping("/fourthroad")
@Api(tags = "山海垦荒之旅坐标接口")
public class FourthroadController {

    @Autowired
    FourthroadService fourthroadService;

    @ApiOperation(value = "获取第四条路的坐标信息")
    @GetMapping("/getFourthRoad")
    public Result getFourthRoad(){
        List<Fourthroad> fourthroadList = fourthroadService.list();
        return Result.success(fourthroadList);
    }
}
