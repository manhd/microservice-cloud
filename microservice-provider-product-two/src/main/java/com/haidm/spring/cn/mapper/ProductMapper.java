package com.haidm.spring.cn.mapper;

import com.haidm.spring.cn.entities.Product;

import java.util.List;
import java.util.Map;

//@Mapper
public interface ProductMapper {

    List<Map> productList();

    Product queryById(Long pid);

    int insertProduct(Product product);

    int deletePriductById(Long pid);
}
