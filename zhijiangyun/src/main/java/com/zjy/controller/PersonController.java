package com.zjy.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.zjy.entity.Literature;
import com.zjy.entity.Person;
import com.zjy.entity.PersonPart;
import com.zjy.mapper.PersonMapper;
import com.zjy.service.PersonService;
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
@RequestMapping("/person")
@Api(tags = "红色人物接口")
public class PersonController {
    @Autowired
    PersonService personService;
    @Autowired
    PersonMapper personMapper;


    @ApiOperation(value = "获取一批红色人物")
    @GetMapping("/getPersons")
    public Result getPersons(){
        List<PersonPart> people = personService.getPersonList();
        return Result.success(people);
    }

    @ApiOperation(value = "根据Id获取红色人物")
    @GetMapping("/getPersonById")
    public Result getLiteratureById(@RequestParam(required = true) Serializable id){
        Person person = personService.getOne(new QueryWrapper<Person>()
                .eq("id", id));

        Assert.notNull(person,"该红色人物不存在");
        return Result.success(person);
    }

    @ApiOperation(value = "根据页码获取一批红色人物")
    @GetMapping("/getPersonsByPage")
    public Result getPersonsByPage(@RequestParam(value = "page")int page){
        List<PersonPart> personList=null;
        switch (page){
            case 1:
                personList = personMapper.getFirstPersonList();
                break;
            case 2:
                personList=personMapper.getSecondPersonList();
                break;
            case 3:
                personList=personMapper.getThirdPersonList();
                break;
            case 4:
                personList=personMapper.getFourthPersonList();
                break;
            default:
                return Result.fail("ErrorPage");
        }

        return Result.success(personList);
    }
}
