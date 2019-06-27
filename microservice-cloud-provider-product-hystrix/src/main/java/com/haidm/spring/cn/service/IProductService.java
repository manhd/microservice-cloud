package com.haidm.spring.cn.service;

import com.haidm.spring.cn.entities.Product;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ProductService
 * @Description TODO
 * @Author sh-manhd
 * @Date 2019/5/21 16:18
 * @Version 1.0
 **/
public interface IProductService {

    List<Map> productList();

    Product queryById(Long pid);

    int insertProduct(Product product);

    int deletePriductById(Long pid);
}
