package com.zjy.mapper;

import com.zjy.entity.Video;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjy.entity.VideoLike;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Fan
 * @since 2021-08-07
 */
@Mapper
public interface VideoMapper extends BaseMapper<Video> {
    int updateVideoById(VideoLike videoLike);

    List<Video>getFirstVideoList();
    List<Video>getSecondVideoList();
    List<Video>getThirdVideoList();
    List<Video>getFourthVideoList();

}
