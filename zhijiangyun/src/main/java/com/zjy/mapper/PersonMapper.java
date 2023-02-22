package com.zjy.mapper;

import com.zjy.entity.Person;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjy.entity.PersonPart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Fan
 * @since 2021-08-07
 */
@Mapper
public interface PersonMapper extends BaseMapper<Person> {
    List<PersonPart> getPersonList();

    List<PersonPart> getFirstPersonList();
    List<PersonPart> getSecondPersonList();
    List<PersonPart> getThirdPersonList();
    List<PersonPart> getFourthPersonList();
}
