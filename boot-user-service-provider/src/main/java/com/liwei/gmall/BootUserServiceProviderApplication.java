package com.liwei.gmall;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ImportResource;

/**
 *   1.导入依赖
 *    1.1导入dubbo-starter
 *    1.2导入dubbo的其他依赖(zookeeper的控制台)
 *
 *   springboot与dubbo整合的三种
 *      1.导入dubbo-starter，在application.properties里面配置属性，使用@Service和@Reference(做不到方法级别的配置)
 *      2.保留dubbo的xml配置文件,依旧导入starter然后使用@ImportResource导入xml文件
 *      3.使用注解api的方式：将每一个组件手动创建到容器中
 *
 */
@EnableDubbo  //开启基于注解的dubbo功能，第一种方式的时候用的
//@ImportResource(locations = "classpath:provider.xml")
@EnableHystrix  //开启异常容错
@SpringBootApplication
public class BootUserServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootUserServiceProviderApplication.class, args);
    }

}
