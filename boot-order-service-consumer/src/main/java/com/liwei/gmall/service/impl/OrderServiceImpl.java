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
    @Reference(check = false,timeout = 2000,retries = 3,version = "*",url = "127.0.0.1:20880",loadbalance = "random")
    //check启动时候检查,timeout设置超时时间,避免线程阻塞,retries:不包括第一次,
    //url dubbo直连：可以不用zookeeper进行管理,可以直接和发送者进行联系用url进行联系
    //loadbalance:random随机,roundrobin轮询,leastactive最少活跃调用数,consistenthash一致性Hash
    //可以用dubbo的7001的页面管理对请求的权重进行分配
    //可以用dubbo的7001的页面的屏蔽:若某个ip和端口的服务不够，可以将相同的ip和端口的其余服务屏蔽掉，让其余服务所有的请求不去处理直接返回null
    //可以用dubbo的7001的页面的容错:若某个ip和端口的服务容易出现报错，可以让该请求若出现报错，不返回报错信息而返回null
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
