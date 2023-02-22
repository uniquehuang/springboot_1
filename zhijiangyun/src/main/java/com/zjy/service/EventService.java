package com.zjy.service;

import com.zjy.entity.Event;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zjy.entity.EventPart;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Fan
 * @since 2021-08-07
 */
@Service
public interface EventService extends IService<Event> {
    List<EventPart> getEventList();
}
