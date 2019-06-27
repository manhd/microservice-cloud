package com.haidm.spring.cn.mapper;

import com.haidm.spring.cn.entities.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductMapper {

    List<Map> productList();

    Product queryById(Long pid);

    int insertProduct(Product product);

    int deletePriductById(Long pid);
}
