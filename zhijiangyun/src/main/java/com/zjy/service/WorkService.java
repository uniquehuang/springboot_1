package com.zjy.service;

import com.zjy.entity.Work;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zjy.entity.WorkPart;
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
public interface WorkService extends IService<Work> {
    List<WorkPart> getWorkList();
}
