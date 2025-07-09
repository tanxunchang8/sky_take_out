package com.sky.service;


import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;

/**
 * @FileName UserService
 * @Description: 用户服务接口
 * @Author tan
 * @date 2025-07-07
 **/

public interface UserService {
    /**
     * description: 微信登录
     * @since: 1.0.0
     * @author: tan
     * @date: 2025/7/7 22:55
     * @Param userLoginDTO:
     * @return: com.sky.entity.User
     */
    User wxLogin(UserLoginDTO userLoginDTO);
}
