package com.haidm.spring.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName ConsumerProductApplication
 * @Description 商品消费者启动类
 * @Author sh-manhd
 * @Date 2019/5/29 14:15
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaClient  //标示为一个eureka 客户端
public class ConsumerProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerProductApplication.class,args);
    }
}
