package com.haidm.spring.cn.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ConfigClient
 * @Description TODO
 * @Author sh-manhd
 * @Date 2019/6/4 11:18
 * @Version 1.0
 **/
@RestController
public class ConfigClient {

    @Value("${server.port}")
    private String port;

    @Value("${spring.applications.name}")
    private String applicationName;


    @GetMapping("/config")
    public String config(){
        String content  = "applicationName:" +applicationName + ",port:" + port;
        System.out.print(content);
        return content;
    }
}
