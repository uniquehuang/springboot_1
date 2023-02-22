package com.zjy.service.impl;

import com.zjy.entity.Message;
import com.zjy.mapper.MessageMapper;
import com.zjy.service.MessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Fan
 * @since 2021-12-23
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

}
