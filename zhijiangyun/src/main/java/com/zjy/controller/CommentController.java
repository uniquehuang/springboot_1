package com.zjy.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjy.entity.Comment;
import com.zjy.entity.Note;
import com.zjy.entity.NotePart;
import com.zjy.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Fan
 * @since 2021-09-08
 */
@RestController
@RequestMapping("/comment")
@Api(tags = "评论接口")
public class CommentController {

    @Autowired
    CommentService commentService;

    @ApiOperation(value = "评论上传接口")
    @PostMapping("/addComment")
    public Result addComment(@RequestBody Comment comment){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        comment.setTime((format.format(date)));
        commentService.save(comment);
        return Result.success("评论成功");
    }

    @ApiOperation(value = "根据title获取评论")
    @GetMapping("/getComment")
    public Result getNoteListByUserPhone(@RequestParam("title") String title){
        List<Comment> comments=commentService.getBaseMapper().selectList(new QueryWrapper<Comment>()
                .eq("title",title)
                .orderByDesc("id"));
        return Result.success(comments);
    }

}
