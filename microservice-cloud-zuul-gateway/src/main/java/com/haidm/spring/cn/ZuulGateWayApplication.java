package com.haidm.spring.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @ClassName ZuulGateWayApplication
 * @Description 路由网关
 * @Author sh-manhd
 * @Date 2019/6/3 14:49
 * @Version 1.0
 **/
@EnableZuulProxy // 开启路由网关
@SpringBootApplication
public class ZuulGateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulGateWayApplication.class,args);
    }
}
