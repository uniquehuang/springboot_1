package com.zjy.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjy.entity.*;
import com.zjy.mapper.EventMapper;
import com.zjy.service.EventService;
import com.zjy.service.ReadnumbersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
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
@RequestMapping("/event")
@Api(tags = "红色事迹接口")
public class EventController {
    @Autowired
    EventService eventService;

    @Autowired
    EventMapper eventMapper;

    @Autowired
    ReadnumbersService readnumbersService;


    @ApiOperation(value = "获取一批红色事迹")
    @GetMapping("/getEvents")
    public Result getEvents(){
        List<EventPart> events = eventService.getEventList();
        return Result.success(events);
    }

    @ApiOperation(value = "根据Id获取红色事迹")
    @GetMapping("/getEventById")
    public Result getEventById(@RequestParam(required = true) Serializable id,@RequestParam(required = true)String userphone){
        Event event = eventService.getOne(new QueryWrapper<Event>()
                .eq("id", id));
        Readnumbers read = readnumbersService.getOne(new QueryWrapper<Readnumbers>()
                .eq("userphone", userphone).eq("eventid", id));
        if (read!=null)
        event.setReadflag(read.getReadflag());

        return Result.success(event);
    }

    @ApiOperation(value = "根据页码数获取一批红色事迹")
    @GetMapping("/getEventsByPage")
    public Result getEventsByPage(@RequestParam(value = "page")int page){
        List<EventPart> events = null;
      switch (page){
          case 1:
              events=eventMapper.getFirstEventList();
              break;
          case 2:
              events=eventMapper.getSecondEventList();
              break;
          case 3:
              events=eventMapper.getThirdEventList();
              break;
          case 4:
              events=eventMapper.getFourthEventList();
              break;
          case 5:
              events=eventMapper.getFifthEventList();
              break;
          default:
              return Result.fail("ErrorPage");
      }


        return Result.success(events);
    }

    @ApiOperation(value = "根据title获取红色事件")
    @GetMapping("/getEventByTitle")
    public Result getEventByTitle(@RequestParam(required = true) String title){
        List<Event> events = eventService.list(new QueryWrapper<Event>()
                .like("title", title));
        Assert.notNull(events,"红色事迹不存在");

        List<Search> list = new ArrayList<Search>();

        for (Event event : events) {
            Search search =new Search();
            search.setId(event.getId());
            search.setTitle(event.getTitle());
            list.add(search);
        }
        return Result.success(list);
    }
}
