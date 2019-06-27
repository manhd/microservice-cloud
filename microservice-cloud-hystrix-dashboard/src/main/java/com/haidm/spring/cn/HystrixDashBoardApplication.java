package com.haidm.spring.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @ClassName HystrixDashBoardApplication
 * @Description 服务监控
 * @Author sh-manhd
 * @Date 2019/6/3 11:04
 * @Version 1.0
 **/
@EnableHystrixDashboard //表示开启服务监控
@SpringBootApplication
public class HystrixDashBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashBoardApplication.class,args);
    }
}
