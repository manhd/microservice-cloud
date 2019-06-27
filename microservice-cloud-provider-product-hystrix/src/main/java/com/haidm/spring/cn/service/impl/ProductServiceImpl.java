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
        int result= 0;
        long startTime = System.currentTimeMillis();
        for(int i = 1; i<=200000; i++){
            product.setDbSource("springcloud_db01");
            product.setProductName("娃哈哈1");
            System.out.println(result);
            result = result+ productMapper.insertProduct(product);
        }

        for(int j = 1; j<=100000; j++){
            product.setDbSource("springcloud_db01");
            product.setProductName("娃哈哈2");
            System.out.println(result);
            result = result+ productMapper.insertProduct(product);
        }





        for(int i = 1; i<=80000; i++){
            product.setDbSource("springcloud_db01");
            product.setProductName("面包1");
            System.out.println(result);
            result = result+ productMapper.insertProduct(product);
        }

        for(int j = 1; j<=100000; j++){
            product.setDbSource("springcloud_db01");
            product.setProductName("面包2");
            System.out.println(result);
            result = result+ productMapper.insertProduct(product);
        }

        long endTime = System.currentTimeMillis()-startTime;
        System.out.println("总耗时为="+endTime);
        System.out.println("总共执行数据为["+result+"]条");
        return result;
    }

    @Override
    public int deletePriductById(Long pid) {
        return productMapper.deletePriductById(pid);
    }
}
