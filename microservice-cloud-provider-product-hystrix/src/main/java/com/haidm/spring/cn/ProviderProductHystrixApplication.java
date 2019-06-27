package com.haidm.spring.cn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @ClassName ProviderProduct
 * @Description 商品提供者启动类
 * @Author sh-manhd
 * @Date 2019/5/22 9:07
 * @Version 1.0
 **/
@EnableHystrix //开启Hystrix 的熔断机制
@EnableEurekaClient //将服务注册到eureka 注册中心
@MapperScan("com.haidm.spring.cn.mapper")
@SpringBootApplication
public class ProviderProductHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderProductHystrixApplication.class,args);
    }
}
