package com.zjy.service.impl;

import com.zjy.entity.Event;
import com.zjy.entity.EventPart;
import com.zjy.mapper.EventMapper;
import com.zjy.mapper.UserMapper;
import com.zjy.service.EventService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Fan
 * @since 2021-08-07
 */
@Service
public class EventServiceImpl extends ServiceImpl<EventMapper, Event> implements EventService {
    @Autowired
    private EventMapper eventMapper;
    public List<EventPart> getEventList(){
        return eventMapper.getEventList();
    }
}
