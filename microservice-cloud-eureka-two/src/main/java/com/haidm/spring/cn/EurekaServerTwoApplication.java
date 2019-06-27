package com.haidm.spring.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName EurekaServerTwoApplication
 * @Description eureka 集群搭建
 * @Author sh-manhd
 * @Date 2019/5/29 15:59
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaServer //标示为一个eureka 服务
public class EurekaServerTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerTwoApplication.class,args);
    }
}
