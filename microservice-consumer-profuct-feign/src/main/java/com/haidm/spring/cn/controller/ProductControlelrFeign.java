package com.haidm.spring.cn.controller;

import com.haidm.spring.cn.entities.Product;
import com.haidm.spring.cn.feignservice.ProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ProductControlelr
 * @Description 用  feign 调用 商品生产者
 * @Author sh-manhd
 * @Date 2019/5/29 13:57
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "consumer/")
public class ProductControlelrFeign {

    @Autowired
    private ProductClientService productClientService;

    /**
     *@Author manhd
     *@Description //商品添加
     *@Date 2019/5/29 14:06
     *@Param
     *@Return
    **/
    @PostMapping(value = "add")
    public Integer add(Product product){
        return productClientService.insertProduct(product);
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
        return productClientService.productList();
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
        return productClientService.queryById(id);
    }


    /**
     *@Author manhd
     *@Description //根据商品Id 查询商品
     *@Date 2019/5/29 14:06
     *@Param
     *@Return
     **/
    @GetMapping(value = "deletePriductById/{id}")
    public Integer deletePriductById(@PathVariable("id") Long id){
        // 请求地址     请求参数   返回参数类型
        return productClientService.deletePriductById(id);
    }
}
