package com.zjy.controller;


import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjy.entity.User;
import com.zjy.entity.Video;
import com.zjy.entity.VideoLike;
import com.zjy.mapper.VideoMapper;
import com.zjy.service.UserService;
import com.zjy.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Fan
 * @since 2021-08-07
 */
@Api(tags = "红色影像接口")
@RestController
@RequestMapping("/video")
public class VideoController {
    @Autowired
    VideoService videoService;

    @Autowired
    VideoMapper videoMapper;

    @ApiOperation(value = "获取一批video")
    @GetMapping("/getVideos")
    public Result getVideos(){
        List<Video> videos = videoService.list();
        return Result.success(videos);
    }

    @ApiOperation(value = "根据Id获取Video")
    @GetMapping("/getVideoById")
    public Result getVideoById(@RequestParam(required = true) Serializable id){
        Video video = videoService.getOne(new QueryWrapper<Video>()
                .eq("id",id));

        Assert.notNull(video,"该视频不存在");

       return Result.success(video);
    }

    @ApiOperation(value = "根据Id更新Video的点赞收藏数量")
    @PostMapping("/updateVideoById")
    public Result updateVideoById(@Validated @RequestBody VideoLike videoLike){
        Result result = null;
        int i = videoService.updateVideoById(videoLike);
        if (i!=0){
            result=Result.success("操作成功");
        }else {
            result=Result.fail("操作失败");
        }
        return result;
    }

    @ApiOperation(value = "根据页码获取一批video")
    @GetMapping("/getVideosByPage")
    public Result getVideosByPage(@RequestParam(value = "page")int page){
        List<Video> videos = null;
        switch (page){
            case 1:
                videos = videoMapper.getFirstVideoList();
                break;
            case 2:
                videos =videoMapper.getSecondVideoList();
                break;
            case 3:
                videos=videoMapper.getThirdVideoList();
                break;
            case 4:
                videos=videoMapper.getFourthVideoList();
                break;
            default:
               return Result.fail("ErrorPage");

        }
        return Result.success(videos);
    }

}
