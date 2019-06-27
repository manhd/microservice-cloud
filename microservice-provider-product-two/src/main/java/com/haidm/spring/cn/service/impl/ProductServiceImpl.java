package com.haidm.spring.cn.service.impl;

import com.haidm.spring.cn.entities.Product;
import com.haidm.spring.cn.mapper.ProductMapper;
import com.haidm.spring.cn.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ProductServiceImpl
 * @Description TODO
 * @Author sh-manhd
 * @Date 2019/5/21 16:19
 * @Version 1.0
 **/
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Map> productList() {
        return productMapper.productList();
    }

    @Override
    public Product queryById(Long pid) {
        return productMapper.queryById(pid);
    }

    @Override
    public int insertProduct(Product product) {
        return productMapper.insertProduct(product);
    }

    @Override
    public int deletePriductById(Long pid) {
        return productMapper.deletePriductById(pid);
    }
}
