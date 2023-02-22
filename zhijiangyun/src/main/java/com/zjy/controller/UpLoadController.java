package com.zjy.controller;

import com.zjy.entity.Forum;
import com.zjy.service.ForumService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @description: 上传文件控制器
 * @author: nxq email: niuxiangqian163@163.com
 * @createDate: 2020/12/19 4:09 下午
 * @updateUser: nxq email: niuxiangqian163@163.com
 * @updateDate: 2020/12/19 4:09 下午
 * @updateRemark:
 * @version: 1.0
 **/
@RestController
@Api(tags = "普通图像上传接口")
public class UpLoadController {


    @PostMapping("/upload")
    public Result upload(@RequestParam("file")MultipartFile file){

    return Result.success(saveFile(file));
    }
  /*  @PostMapping(value = "/multiUpload")
    public Result multiUpload(@RequestParam(value = "file1",required = false)MultipartFile file1,
                              @RequestParam(value = "file2",required = false)MultipartFile file2,
                              @RequestParam(value = "file3",required = false)MultipartFile file3){
        List<String> list = null;
        if (file1!=null)
       list.add(saveFile(file1));
        if (file2!=null)
       list.add(saveFile(file2));
        if (file3!=null)
       list.add(saveFile(file3));
        return Result.success(list);
    }*/

    private String saveFile(MultipartFile file){
        if (file.isEmpty()){
            return "未选择文件";
        }
        String filename = file.getOriginalFilename(); //获取上传文件原来的名称
        String filePath = "C:\\BtSoft\\tomcat\\tomcat9\\webapps\\resource\\upload\\";
        File temp = new File(filePath);
        if (!temp.exists()){
            temp.mkdirs();
        }
        String url =("http://39.108.56.102:8083/resource/upload/"+filename);
        File localFile = new File(filePath+filename);
        try {
            file.transferTo(localFile); //把上传的文件保存至本地
            System.out.println(file.getOriginalFilename()+" 上传成功");
        }catch (IOException e){
            e.printStackTrace();
            return "上传失败";
        }

        return url;
    }
}