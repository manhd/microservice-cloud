package com.haidm.spring.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName EurekaServerApplication
 * @Description eureka 启动类
 * @Author sh-manhd
 * @Date 2019/5/29 15:18
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaServer //表示为一个eureka 服务端
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class,args);
    }
}
