package com.liwei.gmall.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liwei.gmall.bean.UserAddress;
import com.liwei.gmall.service.OrderService;
import com.liwei.gmall.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    //这里设置的参数都是针对 某一服务进行的特殊设置
    @Reference(check = false,timeout = 2000,retries = 3)//check启动时候检查,timeout设置超时时间,避免线程阻塞,retries:不包括第一次
    //@Autowired
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
