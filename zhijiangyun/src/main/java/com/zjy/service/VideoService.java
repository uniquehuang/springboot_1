package com.zjy.service;

import com.zjy.entity.Video;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zjy.entity.VideoLike;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Fan
 * @since 2021-08-07
 */
@Service
public interface VideoService extends IService<Video> {
    int updateVideoById(VideoLike videoLike);
}
