package com.zjy.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjy.entity.*;
import com.zjy.service.ReadnumbersService;
import com.zjy.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Fan
 * @since 2021-08-05
 */
@Api(tags = "用户接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;




    @Autowired
    ReadnumbersService readnumbersService;

    @ApiOperation(value = "用户注册")
    @PostMapping("/addUser")
    public Result addUser(@Validated @RequestBody RegisterUser registerUser){
        Result result = null;
        List<User> list = userService.list();

        for (int i1 = 0; i1 < list.size(); i1++) {
            if (registerUser.getUserphone().equals(list.get(i1).getUserphone())) {
                result = Result.fail("用户已存在");
                return result;
            }
        }
        int i = userService.addUser(registerUser);
        if (i != 0) {
            result = Result.success("注册成功");
        } else {
            result = Result.fail("注册失败");
        }
        return result;

    }





    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    public Result login(@Validated @RequestBody Userlogin userlogin){
        User user = userService.getOne(new QueryWrapper<User>()
        .eq("userphone",userlogin.getUserphone()));

        Assert.notNull(user,"用户不存在");
        if (!user.getPassword().equals
                (userlogin.getPassword())) {
            return Result.fail("密码错误！");
        }


        return Result.success(user);
        //通过map的形式返回需要的部分信息
    /*    return Result.success(MapUtil.builder()
                .put("id", user.getId())
                .put("userphone", user.getUserphone())
                .put("password", user.getPassword())
                .put("username", user.getUsername())
                .put("gender",user.getGender())
                .put("code",user.getCode())
                .map()
        );*/

    }

    @ApiOperation(value = "获取用户积分列表")
    @GetMapping("/getUserCodeList")
    public Result getUserCodeList(){

        List<UserCode> userCodeList = userService.getUserCodeList();
        return Result.success(userCodeList);
    }


   /* @ApiOperation(value = "根据Id更新用户积分表")
    @PostMapping("/updateUserCodeById")
    public Result updateUserCodeById(@Validated @RequestBody UserTotalCode userTotalCode){
        Result result = null;
        int i = userService.updateUserCodeById(userTotalCode);
        if (i!=0){
            result=Result.success("操作成功");
        }else {
            result=Result.fail("操作失败");
        }
        return result;
    }*/

    @ApiOperation(value = "根据Id更新用户打卡天数")
    @PostMapping("/updateUserStudyDaysCountById")
    public Result updateUserStudyDaysCountById(@RequestParam(value = "id") int id,@ApiParam(value = "用户打卡天数")@RequestParam(value = "studydayscount")int studydayscount){
        User user = userService.getById(id);
        Assert.notNull(user,"用户不存在");
        user.setStudydayscount(studydayscount);
        userService.updateById(user);
        return Result.success("操作成功");
    }

    @ApiOperation(value = "根据Id更新用户对战积分")
    @PostMapping("/updateUserPKCodeById")
    public Result updateUserPKCodeById(@RequestParam(value = "id") int id,@ApiParam(value = "用户对战积分") @RequestParam(value = "pkcode")int pkcode){
        User user = userService.getById(id);
        Assert.notNull(user,"用户不存在");
        user.setPkcode(pkcode);
        user.setCode(user.getReplycode()+pkcode);
        userService.updateById(user);
        return Result.success("操作成功");
    }
    @ApiOperation(value = "根据Id更新用户答题积分")
    @PostMapping("/updateUserReplyCodeById")
    public Result updateUserReplyCodeById(@RequestParam(value = "id") int id,@ApiParam(value = "用户答题积分") @RequestParam(value = "replycode")int replycode){
        User user = userService.getById(id);
        Assert.notNull(user,"用户不存在");
        user.setReplycode(replycode);
        user.setCode(user.getPkcode()+replycode);
        userService.updateById(user);
        return Result.success("操作成功");
    }
    @ApiOperation(value = "根据Id更新用户拼图难度等级")
    @PostMapping("/updateUserLevelById")
    public Result updateUserLevelById(@RequestParam(value = "id") int id,@ApiParam(value = "用户选择拼图等级") @RequestParam(value = "level")int level){
        User user = userService.getById(id);
        Assert.notNull(user,"用户不存在");
        user.setLevel(level);
        userService.updateById(user);
        return Result.success("操作成功");
    }
    @ApiOperation(value = "根据用户手机号更新用户点赞数")
    @PostMapping("/updateUserDZCountByUserPhone")
    public Result updateUserDZCountByUserPhone(@RequestParam(value = "userphone") String userphone,@ApiParam(value = "用户点赞数") @RequestParam(value = "dzcount")int dzcount){
        User user = userService.getOne(new QueryWrapper<User>().eq("userphone",userphone));
        Assert.notNull(user,"用户不存在");
        user.setDzcount(dzcount);
        userService.updateById(user);
        return Result.success("操作成功");
    }
    @ApiOperation(value = "根据Id更新用户答题答对次数")
    @PostMapping("/updateUserDrawRightById")
    public Result updateUserDrawRightById(@RequestParam(value = "id") int id,@ApiParam(value = "用户答题答对次数") @RequestParam(value = "drawright")int drawright){
        User user = userService.getById(id);
        Assert.notNull(user,"用户不存在");
        user.setDrawright(drawright);
        userService.updateById(user);
        return Result.success("操作成功");
    }

    @ApiOperation(value = "根据userphone更新用户阅读篇数")
    @PostMapping("/updateUserReadByUserPhone")
    public Result updateUserReadByUserPhone(@Validated @RequestBody ReadPart readPart){
        User user = userService.getOne(new QueryWrapper<User>()
                .eq("userphone",readPart.getUserphone()));
        Readnumbers read1=new Readnumbers();
        Assert.notNull(user,"用户不存在");
        List<Readnumbers> list = readnumbersService.list();
        if(readPart.getReadflag()==1){
            for (int i1 = 0; i1 < list.size(); i1++) {
                if (readPart.getEventid().equals(list.get(i1).getEventid())&&readPart.getUserphone().equals(list.get(i1).getUserphone())) {
                    return Result.success("此文章已阅读");
                }
            }
        read1.setReadflag(readPart.getReadflag());
        read1.setEventid(readPart.getEventid());
        read1.setUserphone(readPart.getUserphone());
        readnumbersService.save(read1);
        user.setReadnumber(user.getReadnumber()+1);
        userService.updateById(user);
        return Result.success("完成阅读");
        }
        else {
            readnumbersService.remove(new QueryWrapper<Readnumbers>().eq("userphone",readPart.getUserphone())
            .eq("eventid",readPart.getEventid()));
            user.setReadnumber(user.getReadnumber()-1);
            userService.updateById(user);
            return Result.success("取消成功");
        }
    }

}
