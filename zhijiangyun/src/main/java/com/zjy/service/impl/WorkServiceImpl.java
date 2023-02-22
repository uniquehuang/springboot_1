package com.zjy.service.impl;

import com.zjy.entity.Work;
import com.zjy.entity.WorkPart;
import com.zjy.mapper.WorkMapper;
import com.zjy.service.WorkService;
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
public class WorkServiceImpl extends ServiceImpl<WorkMapper, Work> implements WorkService {

    @Autowired
    WorkMapper workMapper;


    @Override
    public List<WorkPart> getWorkList() {
        return workMapper.getWorkList();
    }
}
