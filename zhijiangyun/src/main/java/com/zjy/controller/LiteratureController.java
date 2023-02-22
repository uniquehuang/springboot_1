package com.zjy.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjy.entity.Literature;
import com.zjy.entity.LiteraturePart;
import com.zjy.entity.Video;
import com.zjy.entity.Work;
import com.zjy.mapper.LiteratureMapper;
import com.zjy.service.LiteratureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Fan
 * @since 2021-08-07
 */
@Api(tags = "重要文献接口")
@RestController
@RequestMapping("/literature")
public class LiteratureController {
    @Autowired
    LiteratureService literatureService;

    @Autowired
    LiteratureMapper literatureMapper;

    @ApiOperation(value = "获取一批重要文献")
    @GetMapping("/getLiteratures")
    public Result getLiteratures(){
        List<LiteraturePart> literatures = literatureService.getLiteratureList();
        return Result.success(literatures);
    }

    @ApiOperation(value = "根据Id获取重要文献")
    @GetMapping("/getLiteratureById")
    public Result getLiteratureById(@RequestParam(required = true) Serializable id){
        Literature literature = literatureService.getOne(new QueryWrapper<Literature>()
                .eq("id", id));

        Assert.notNull(literature,"该文献不存在");

        return Result.success(literature);
    }

    @ApiOperation(value = "根据页码获取一批重要文献")
    @GetMapping("/getLiteraturesByPage")
    public Result getLiteraturesByPage(@RequestParam(value = "page")int page){

        List<Literature> literatureList=null;
        switch (page){
            case 1:
                literatureList = literatureMapper.getFirstLiteratureList();
                break;
            case 2:
                literatureList=literatureMapper.getSecondLiteratureList();
                break;
            default:
                return Result.fail("ErrorPage");
        }

        return Result.success(literatureList);
    }


}
