package com.haidm.spring.cn.controller;

import com.haidm.spring.cn.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ProductControlelr
 * @Description TODO
 * @Author sh-manhd
 * @Date 2019/5/29 13:57
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "consumer/")
public class ProductControlelr {

    //private final static String REST_URL_PERFIX = "http://localhost:32231";
    private final static String REST_URL_PERFIX = "http://microservice-provider-product";

    @Autowired
    private RestTemplate restTemplate;


    /**
     *@Author manhd
     *@Description //商品添加
     *@Date 2019/5/29 14:06
     *@Param
     *@Return
    **/
    @PostMapping(value = "add")
    public Integer add(Product product){
        // 请求地址     请求参数   返回参数类型
        return restTemplate.postForObject(REST_URL_PERFIX + "/product/insertProduct", product, Integer.class);
    }

    /**
     *@Author manhd
     *@Description //商品列表查询
     *@Date 2019/5/29 14:06
     *@Param
     *@Return
     **/
    @GetMapping(value = "productList")
    public List<Map> productList(){
        // 请求地址     请求参数   返回参数类型
        return restTemplate.getForObject(REST_URL_PERFIX + "/product/productList", List.class);
    }

    /**
     *@Author manhd
     *@Description //根据商品Id 查询商品
     *@Date 2019/5/29 14:06
     *@Param
     *@Return
     **/
    @GetMapping(value = "queryById/{id}")
    public Product queryById(@PathVariable("id") Long id){
        // 请求地址     请求参数   返回参数类型
        return restTemplate.getForObject(REST_URL_PERFIX + "/product/queryById/" + id,  Product.class);
    }


    /**
     *@Author manhd
     *@Description //根据商品Id 查询商品
     *@Date 2019/5/29 14:06
     *@Param
     *@Return
     **/
    @GetMapping(value = "deletePriductById/{id}")
    public Product deletePriductById(@PathVariable("id") Long id){
        // 请求地址     请求参数   返回参数类型
        return restTemplate.getForObject(REST_URL_PERFIX + "/product/deletePriductById/" + id,  Product.class);
    }
}
