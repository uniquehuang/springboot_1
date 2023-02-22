package com.zjy.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjy.entity.*;
import com.zjy.service.NoteService;
import com.zjy.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Fan
 * @since 2021-08-30
 */
@RestController
@RequestMapping("/note")
@Api(tags = "笔记上传接口")
public class NoteController {

    @Autowired
    NoteService noteService;

    @Autowired
    UserService userService;

    @ApiOperation(value = "笔记上传接口")
    @PostMapping("/addNote")
    public Result addNote(@RequestBody NotePart notePart){
        Result result = null;
        Note note1 =new Note();
        note1.setUserphone(notePart.getUserphone());
        note1.setTitle(notePart.getTitle());
        note1.setNote(notePart.getNote());
        noteService.save(note1);

        return Result.success(note1);
    }

    @ApiOperation(value = "根据userphone获取用户笔记")
    @GetMapping("/getNoteListByUserPhone")
    public Result getNoteListByUserPhone(@RequestParam("userphone") String userphone){
        List<Note> notes =noteService.getBaseMapper().selectList(new QueryWrapper<Note>()
                .eq("userphone",userphone)
                .orderByDesc("id"));
        return Result.success(notes);
    }
}
