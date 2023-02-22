package com.zjy.service.impl;

import com.zjy.entity.RegisterUser;
import com.zjy.entity.User;
import com.zjy.entity.UserCode;
import com.zjy.entity.UserTotalCode;
import com.zjy.mapper.UserMapper;
import com.zjy.service.UserService;
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
 * @since 2021-08-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(RegisterUser registerUser) {
        return userMapper.addUser(registerUser);
    }
    public List<UserCode> getUserCodeList(){
        return userMapper.getUserCodeList();
    }

    @Override
    public int updateUserCodeById(UserTotalCode userTotalCode) {
        return userMapper.updateUserCodeById(userTotalCode);
    }

}
