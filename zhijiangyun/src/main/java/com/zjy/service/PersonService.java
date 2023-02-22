package com.zjy.service;

import com.zjy.entity.Person;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zjy.entity.PersonPart;
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
public interface PersonService extends IService<Person> {
    List<PersonPart> getPersonList();
}
