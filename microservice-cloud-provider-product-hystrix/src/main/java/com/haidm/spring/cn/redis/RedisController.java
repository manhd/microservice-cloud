package com.haidm.spring.cn.redis;

import com.haidm.spring.cn.entities.Product;
import com.haidm.spring.cn.untils.RedisTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RedisController
 * @Description TODO
 * @Author sh-manhd
 * @Date 2019/6/21 13:59
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "redis")
public class RedisController {

    @Autowired
    RedisTemplateUtil redisTemplateUtil;

    @GetMapping(value = "strSet")
    public boolean strSetRedis(){

        Product data = getData();

        boolean set = redisTemplateUtil.set("str1", data,Long.valueOf(2000));
        return set;
    }


    @GetMapping(value = "strGet")
    public Product strGetRedis(){

        Product product = (Product) redisTemplateUtil.get("str1");

        return product;
    }




    private Product getData(){
        Product product  = new Product();
        product.setDbSource("dada_source_03");
        product.setPid(Long.valueOf(1));
        product.setProductName("我的产品");
        return product;
    }
}
