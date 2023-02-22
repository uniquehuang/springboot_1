package com.zjy.service.impl;

import com.zjy.entity.EventPart;
import com.zjy.entity.Literature;
import com.zjy.entity.LiteraturePart;
import com.zjy.mapper.EventMapper;
import com.zjy.mapper.LiteratureMapper;
import com.zjy.service.LiteratureService;
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
public class LiteratureServiceImpl extends ServiceImpl<LiteratureMapper, Literature> implements LiteratureService {
    @Autowired
    private LiteratureMapper literatureMapper;

    public List<LiteraturePart> getLiteratureList(){
        return literatureMapper.getLiteratureList();
    }

}
