package com.zjy.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjy.entity.Collect;
import com.zjy.entity.CollectPart;
import com.zjy.entity.Note;
import com.zjy.entity.Scenery;
import com.zjy.service.CollectService;
import com.zjy.service.SceneryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Fan
 * @since 2021-08-31
 */
@RestController
@RequestMapping("/collect")
@Api(tags = "景区收藏接口")
public class CollectController {

    @Autowired
    CollectService collectService;

    @Autowired
    SceneryService sceneryService;

    @ApiOperation(value = "景点收藏接口")
    @PostMapping("/addAttraction")
    public Result addAttraction(@RequestBody CollectPart collectPart){
        Result result = null;
        Collect collect=new Collect();
        if (collectPart.getScflag()==1){

            collect.setUserphone(collectPart.getUserphone());
            collect.setTitle(collectPart.getTitle());
            Scenery scenery = sceneryService.getOne(new QueryWrapper<Scenery>().eq("title", collectPart.getTitle()));
            collect.setScflag(collectPart.getScflag());
            collect.setImgurl(collectPart.getImgurl());
            collect.setText(scenery.getSceneryinfo());
            collectService.save(collect);
            return Result.success("收藏成功");
        }
        else {
            collectService.remove(new QueryWrapper<Collect>().eq("title",collectPart.getTitle())
                    .eq("userphone",collectPart.getUserphone()));
            return Result.success("取消成功");
        }
    }

    @ApiOperation(value = "根据userphone获取用户景点收藏记录")
    @GetMapping("/getAttractionByUserPhone")
    public Result getAttractionByUserPhone(@RequestParam("userphone") String userphone){
        List<Collect> collectList =collectService.getBaseMapper().selectList(new QueryWrapper<Collect>()
                .eq("userphone",userphone)
                .orderByDesc("id"));
        return Result.success(collectList);
    }

}
