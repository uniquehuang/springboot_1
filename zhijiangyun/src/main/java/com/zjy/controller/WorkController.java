package com.zjy.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjy.entity.Video;
import com.zjy.entity.Work;
import com.zjy.entity.WorkPart;
import com.zjy.mapper.WorkMapper;
import com.zjy.service.WorkService;
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
@RestController
@RequestMapping("/work")
@Api(tags = "文艺作品接口")
public class WorkController {

    @Autowired
    WorkService workService;

    @Autowired
    WorkMapper workMapper;

    @ApiOperation(value = "获取一批文艺作品")
    @GetMapping("/getWorks")
    public Result getWorks(){
        List<WorkPart> works = workService.getWorkList();
        return Result.success(works);
    }
    @ApiOperation(value = "根据Id获取文艺作品")
    @GetMapping("/getWorkById")
    public Result getWrokById(@RequestParam(required = true) Serializable id){
       Work work= workService.getOne(new QueryWrapper<Work>()
                .eq("id",id));

        Assert.notNull(work,"该作品不存在");

        return Result.success(work);
    }

    @ApiOperation(value = "根据页码获取一批文艺作品")
    @GetMapping("/getWorksByPage")
    public Result getWorksByPage(@RequestParam(value = "page")int page){
        List<WorkPart> workList=null;
        switch (page){
            case 1:
                workList = workMapper.getFirstWorkList();
                break;
            case 2:
                workList=workMapper.getSecondWorkList();
                break;
            default:
                Result.fail("ErrorPage");
        }
        return Result.success(workList);
    }

}
