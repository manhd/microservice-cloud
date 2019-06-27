package com.haidm.spring.cn.feignservice;

import com.haidm.spring.cn.entities.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ProductClientServiceFallback
 * @Description TODO
 * @Author sh-manhd
 * @Date 2019/5/30 10:09
 * @Version 1.0
 **/
@Component
public class ProductClientServiceFallback implements  ProductClientService{


    @Override
    public List<Map> productList() {
        Map map = new HashMap<>();
        map.put("pid","");
        map.put("productName","");
        map.put("dbSource","");
        List<Map> list = new ArrayList<>();
        list.add(map);
        return new ArrayList<>();
    }

    @Override
    public Product queryById(Long pid) {
        return new Product(pid,"id=" + pid + "无数据--feignclient&hystrix","无有效数据库");
    }

    @Override
    public int insertProduct(Product product) {
        return 0;
    }

    @Override
    public int deletePriductById(Long pid) {
        return 0;
    }
}
