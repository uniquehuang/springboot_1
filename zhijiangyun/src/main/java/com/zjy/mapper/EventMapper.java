package com.zjy.mapper;

import com.zjy.entity.Event;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjy.entity.EventPart;
import com.zjy.entity.UserCode;
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
public interface EventMapper extends BaseMapper<Event> {

    List<EventPart> getEventList();

    List<EventPart> getFirstEventList();
    List<EventPart> getSecondEventList();
    List<EventPart> getThirdEventList();
    List<EventPart> getFourthEventList();
    List<EventPart> getFifthEventList();

}
