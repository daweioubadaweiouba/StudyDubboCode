package com.liwei.gmall;

import com.liwei.gmall.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ConsumerMainApplication {

    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException{

        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("consumer.xml");

        OrderService orderService = ioc.getBean(OrderService.class);

        orderService.initOrder("2");

        System.out.println("调用完成");

        System.in.read();


    }

}
