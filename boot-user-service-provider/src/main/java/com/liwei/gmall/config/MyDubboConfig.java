package com.liwei.gmall.config;

import com.alibaba.dubbo.config.*;
import com.liwei.gmall.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyDubboConfig {

    /**
     *   1.指定当前服务/应用的名字(同样的名字服务相同，不要和别的服务同名)
     *     <dubbo:application name="bootUserServiceProvider"></dubbo:application>
     * @return
     */
    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("bootUserServiceProvider");
        return applicationConfig;
    }

    /**
     * 指定注册中心的位置，让别人能够调用此服务
     *             check:记录失败注册和订阅请求，后台定时重试
     *             username:zookeeper的默认账号
     *             password:zookeeper的默认密码
     *             address:zookeeper提供注册中心的地址
     *
     * @return
     */
    @Bean
    public RegistryConfig registryConfig(){
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("127.0.0.1");
        registryConfig.setPort(2181);
        registryConfig.setUsername("root");
        registryConfig.setPassword("root");
        registryConfig.setCheck(false);
        return registryConfig;
    }

    /**
     *  用dubbo协议在20880端口暴露服务
     * @return
     */
    @Bean
    public ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig =new ProtocolConfig();
        protocolConfig.setCharset("utf-8");
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        return protocolConfig;
    }

    /**
     * 声明需要暴露的服务接口
     *     retries:重试次数，不包含第一次调用
     *     <dubbo:service interface="com.liwei.gmall.service.UserService" ref="UserServiceImpl" timeout="3000" retries="3" version="1.0.0">
     *         <dubbo:method name="getUserAddressList" timeout="4000" retries="4"></dubbo:method>
     *     </dubbo:service>
     */
    @Bean
    public ServiceConfig<UserService> userServiceConfig(UserService userService){
        ServiceConfig<UserService> userServiceConfig = new ServiceConfig<>();
        userServiceConfig.setInterface(UserService.class);
        userServiceConfig.setRef(userService);
        userServiceConfig.setVersion("1.0.0");

        //配置每一个method的信息
        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("getUserAddressList");
        methodConfig.setTimeout(6000);
        methodConfig.setRetries(3);

        List<MethodConfig> list = new ArrayList<>();
        list.add(methodConfig);

        userServiceConfig.setMethods(list);
        return userServiceConfig;
    }

    @Bean
    public MonitorConfig monitorConfig(){
        MonitorConfig monitorConfig = new MonitorConfig("zookeeper");
        return monitorConfig;
    }

}