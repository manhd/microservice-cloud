package com.haidm.spring.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @ClassName ConsumerProductApplication
 * @Description 商品消费者启动类
 * @Author sh-manhd
 * @Date 2019/5/29 14:15
 * @Version 1.0
 **/
//会扫描指定包下面 用 @FeignClient 标示的接口
@EnableFeignClients(basePackages = "com.haidm.spring.cn.feignservice")
@SpringBootApplication
@EnableEurekaClient  //标示为一个eureka 客户端
public class ConsumerProductFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerProductFeignApplication.class,args);
    }
}
