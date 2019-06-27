package com.haidm.spring.cn.controller;

import com.haidm.spring.cn.entities.Product;
import com.haidm.spring.cn.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ProductController
 * @Description TODO
 * @Author sh-manhd
 * @Date 2019/5/21 16:23
 * @Version 1.0
 **/
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping(value ="productList")
    public List<Map> productList(){
        return iProductService.productList();
    }

    @GetMapping(value ="queryById/{pid}")
    public Product queryById(@PathVariable("pid")Long pid){
        return iProductService.queryById(pid);
    }


    @RequestMapping(value ="insertProduct",method = RequestMethod.POST)
    public int insertProduct(@RequestBody Product product){
        return iProductService.insertProduct(product);
    }

    @GetMapping(value ="deletePriductById/{pid}")
    public int deletePriductById(@PathVariable("pid") Long pid){
        return iProductService.deletePriductById(pid);
    }
}
