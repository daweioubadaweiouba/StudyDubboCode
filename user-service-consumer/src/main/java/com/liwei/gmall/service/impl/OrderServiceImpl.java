package com.liwei.gmall.service.impl;

import com.liwei.gmall.bean.UserAddress;
import com.liwei.gmall.service.OrderService;
import com.liwei.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    UserService userService;

    public String initOrder(String userId){
        //1.查询用户的收货地址
        List<UserAddress> list = userService.getUserAddressList(userId);
        String str = "";
        for(UserAddress obj : list){
            str += obj.toString();
        }
        return str;
    }


}
