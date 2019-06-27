package com.haidm.spring.cn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName ProviderProductTwoApplication
 * @Description 商品服务提供者  2
 * @Author sh-manhd
 * @Date 2019/5/29 17:35
 * @Version 1.0
 **/
@EnableEurekaClient //将服务注册到eureka 注册中心
@MapperScan("com.haidm.spring.cn.mapper")
@SpringBootApplication
public class ProviderProductTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderProductTwoApplication.class,args);
    }
}
