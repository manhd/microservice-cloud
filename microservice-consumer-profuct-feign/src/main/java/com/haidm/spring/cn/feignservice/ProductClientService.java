package com.haidm.spring.cn.feignservice;

import com.haidm.spring.cn.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
//fallback   作用，指定熔断处理类  如果被调用方法处理异常，就会交给熔断处理类
@FeignClient(value = "microservice-provider-product-hystrix/product",fallback = ProductClientServiceFallback.class) //value 为指定调用微服务名称
public interface ProductClientService {

    @GetMapping(value ="productList")
    List<Map> productList();

    @GetMapping(value ="queryById/{pid}")
    Product queryById(@PathVariable("pid")Long pid);


    @RequestMapping(value ="insertProduct",method = RequestMethod.POST)
    int insertProduct(@RequestBody Product product);

    @GetMapping(value ="deletePriductById/{pid}")
    int deletePriductById(@PathVariable("pid") Long pid);
}
