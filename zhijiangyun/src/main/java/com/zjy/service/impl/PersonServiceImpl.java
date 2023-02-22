package com.zjy.service.impl;

import com.zjy.entity.Person;
import com.zjy.entity.PersonPart;
import com.zjy.mapper.LiteratureMapper;
import com.zjy.mapper.PersonMapper;
import com.zjy.service.PersonService;
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
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements PersonService {

    @Autowired
    private PersonMapper personMapper;
    @Override
    public List<PersonPart> getPersonList() {
       return personMapper.getPersonList();
    }
}
