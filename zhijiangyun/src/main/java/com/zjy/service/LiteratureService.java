package com.zjy.service;

import com.zjy.entity.EventPart;
import com.zjy.entity.Literature;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zjy.entity.LiteraturePart;
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
public interface LiteratureService extends IService<Literature> {
    List<LiteraturePart> getLiteratureList();
}
