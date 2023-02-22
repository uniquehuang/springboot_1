package com.zjy.controller;


import com.zjy.entity.Secondroad;
import com.zjy.entity.Thirdroad;
import com.zjy.service.SecondroadService;
import com.zjy.service.ThirdroadService;
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
@RequestMapping("/thirdroad")
@Api(tags = "烽火岁月之旅坐标接口")
public class ThirdroadController {

    @Autowired
    ThirdroadService thirdroadService;

    @ApiOperation(value = "获取第三条路的坐标信息")
    @GetMapping("/getThirdRoad")
    public Result getThirdRoad(){
        List<Thirdroad> thirdroadList = thirdroadService.list();
        return Result.success(thirdroadList);
    }

}
