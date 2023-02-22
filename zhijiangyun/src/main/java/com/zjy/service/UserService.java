package com.zjy.service;

import com.zjy.entity.*;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Fan
 * @since 2021-08-05
 */
@Service
public interface UserService extends IService<User> {
    int addUser(RegisterUser registerUser);
    List<UserCode> getUserCodeList();
    int updateUserCodeById(UserTotalCode userTotalCode);
}
