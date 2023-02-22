package com.zjy.mapper;

import com.zjy.entity.Literature;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjy.entity.LiteraturePart;
import com.zjy.entity.UserCode;
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
public interface LiteratureMapper extends BaseMapper<Literature> {

    List<LiteraturePart> getLiteratureList();

    List<Literature>getFirstLiteratureList();
    List<Literature>getSecondLiteratureList();

}
