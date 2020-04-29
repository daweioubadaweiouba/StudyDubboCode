package com.liwei.gmall.controller;

import com.liwei.gmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/OrderController/")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "initOrder",produces = {"application/json;charset=utf-8"})
    public String initOrder(String userId) throws InterruptedException {
        String str = orderService.initOrder(userId);
        return str;
    }

}