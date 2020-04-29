package com.liwei.gmall.service.impl;

import com.liwei.gmall.bean.UserAddress;
import com.liwei.gmall.service.UserService;
import org.springframework.util.StringUtils;

import java.util.List;

public class UserServiceStub implements UserService {

    private final UserService userService;

    public UserServiceStub(UserService userService){
        super();
        this.userService = userService;
    }

    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("远程存根被调用，进行数据的验证");
        if(!StringUtils.isEmpty("")){
           return this.userService.getUserAddressList(userId);
        }
        return null;
    }

}
