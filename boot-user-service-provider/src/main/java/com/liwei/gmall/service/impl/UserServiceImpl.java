package com.liwei.gmall.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.liwei.gmall.bean.UserAddress;
import com.liwei.gmall.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Service(timeout = 6000,retries = 3,version = "1.0.0")  //暴露服务  如果使用api的config开发则不需要service注解
@Component
public class UserServiceImpl implements UserService {

    @HystrixCommand //由hystrix进行代理，
    public List<UserAddress> getUserAddressList(String userId){

        System.out.println("userId"+userId+"3");
        UserAddress obj = new UserAddress(1,"湖北省武汉市","1","bigwei","123123","是");
        UserAddress obj1 = new UserAddress(1,"湖北省武汉市","1","bigwei","123123","是");
        UserAddress obj2 = new UserAddress(1,"湖北省武汉市","2","weibig","321321","否");
        UserAddress obj3 = new UserAddress(1,"湖北省武汉市","2","weibig","321321","否");
        ArrayList<UserAddress> list = new ArrayList<UserAddress>();
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        if(Math.random()>0.5){
            throw new  RuntimeException();
        }
        if(userId.equals(obj.getUserId())){
            list.add(obj);
        }
        if(userId.equals(obj1.getUserId())){
            list.add(obj1);
        }
        if(userId.equals(obj2.getUserId())){
            list.add(obj2);
        }
        if(userId.equals(obj3.getUserId())){
            list.add(obj3);
        }
        return list;
    }




}