package com.zjy.service.impl;

import com.zjy.entity.RegisterUser;
import com.zjy.entity.Video;
import com.zjy.entity.VideoLike;
import com.zjy.mapper.UserMapper;
import com.zjy.mapper.VideoMapper;
import com.zjy.service.VideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Fan
 * @since 2021-08-07
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {
    @Autowired
    private VideoMapper videoMapper;

    @Override
    public int updateVideoById(VideoLike videoLike){
        return videoMapper.updateVideoById(videoLike);
    }
}
