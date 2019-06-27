package com.haidm.spring.cn.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ConfigBean
 * @Description 配置类
 * @Author sh-manhd
 * @Date 2019/5/29 13:53
 * @Version 1.0
 **/
@Configuration //标示为配置类
public class ConfigBean {


    @Bean  //纳入容器
    @LoadBalanced //实现负载均衡   （调用地址可以使用服务名  http:127.0.0.1  等价于 被调用 yml文件中的服务名）
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
