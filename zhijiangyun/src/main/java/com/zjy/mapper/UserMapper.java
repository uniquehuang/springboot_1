package com.zjy.mapper;

import com.zjy.entity.RegisterUser;
import com.zjy.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjy.entity.UserCode;
import com.zjy.entity.UserTotalCode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Fan
 * @since 2021-08-05
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    int addUser(RegisterUser registerUser);

     List<UserCode> getUserCodeList();

    int updateUserCodeById(UserTotalCode userTotalCode);

}
