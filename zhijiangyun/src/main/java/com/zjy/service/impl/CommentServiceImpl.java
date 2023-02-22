package com.zjy.service.impl;

import com.zjy.entity.Comment;
import com.zjy.mapper.CommentMapper;
import com.zjy.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Fan
 * @since 2021-09-08
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
