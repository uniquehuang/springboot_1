package com.zjy.mapper;

import com.zjy.entity.UserCode;
import com.zjy.entity.Work;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjy.entity.WorkPart;
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
public interface WorkMapper extends BaseMapper<Work> {
    List<WorkPart> getWorkList();

    List<WorkPart> getFirstWorkList();

    List<WorkPart> getSecondWorkList();
}
