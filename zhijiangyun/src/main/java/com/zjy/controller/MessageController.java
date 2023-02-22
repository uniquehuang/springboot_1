package com.zjy.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjy.entity.Message;
import com.zjy.entity.Note;
import com.zjy.entity.NotePart;
import com.zjy.entity.User;
import com.zjy.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Fan
 * @since 2021-12-23
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService messageService;


    @PostMapping("/addMessage")
    public Result addMessage(@RequestParam(value = "id") Integer id){

        List<Message> list = messageService.list();

        for (int i1 = 0; i1 < list.size(); i1++) {
            if (id==(list.get(i1).getId())) {
                return Result.fail("设备以添加");
            }
        }
        if(id==1){
            Message message1 = new Message();
            message1.setId(1);
            message1.setImg("http://120.26.90.186:8083/resource/cf.jpeg");
            message1.setDes("厨房场景添加成功");
            messageService.save(message1);
        }
        if(id==2){
            Message message = new Message();
            message.setId(2);
            message.setImg("http://120.26.90.186:8083/resource/kt.jpeg");
            message.setDes("客厅场景添加成功");
            messageService.save(message);
        }


        return Result.success("您收到一条新消息");
    }

    @GetMapping("/getAllMessage")
    public Result getAllMessage(){
        List<Message> list =messageService.list();
        return Result.success(list);
    }
    @GetMapping("/deleteAllMessage")
    public Result deleteAllMessage(){
        messageService.removeById(1);
        messageService.removeById(2);
        return Result.success("消息清除成功");
    }

}
