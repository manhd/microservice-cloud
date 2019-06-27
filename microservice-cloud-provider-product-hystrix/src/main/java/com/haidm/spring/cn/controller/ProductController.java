package com.haidm.spring.cn.controller;

import com.haidm.spring.cn.entities.Product;
import com.haidm.spring.cn.response.ResponseParam;
import com.haidm.spring.cn.response.enums.ResponseStatusEnum;
import com.haidm.spring.cn.service.IProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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


    /**
     *@Author manhd
     *@Description //根据Id 获取商品信息
     * fallbackMethod 指定当 productList 出现异常时，将要处理的方法
     * 处理方法的返回值和参数要一致
     *@Date 2019/5/29 22:34
     *@Param
     *@Return
     **/
    @GetMapping(value ="productList")
    @HystrixCommand(fallbackMethod = "productListFallBack")
    public ResponseParam<List<Map>> productList(){
        ResponseParam result = new ResponseParam<>();
        List<Map> list = iProductService.productList();
        if(null != list & list.size()>0){
            result.setRespInfo(list);
            return result;
        }else {
            result.setRespCode(ResponseStatusEnum.NODATA.getRespCode());
            result.setRespMsg(ResponseStatusEnum.NODATA.getRespMsg());
            return result;
        }
    }

    /**
     *@Author manhd
     *@Description //查询断路器返回方法
     *@Date 2019/6/3 13:43
     *@Param
     *@Return
    **/
    public ResponseParam<List<Map>> productListFallBack (){
        ResponseParam result = new ResponseParam<>();
        result.setRespCode(ResponseStatusEnum.NODATA.getRespCode());
        result.setRespMsg(ResponseStatusEnum.NODATA.getRespMsg());
        return result;
    }


    /**
     *@Author manhd
     *@Description //根据Id 获取商品信息
     * fallbackMethod指定当queryById 出现异常时，将要处理的方法
     * 处理方法的返回值和参数要一致
     *@Date 2019/5/29 22:34
     *@Param
     *@Return
    **/
    @GetMapping(value ="queryById/{pid}")
    @HystrixCommand(fallbackMethod = "queryByIdFallBack")
    public Product queryById(@PathVariable("pid")Long pid){
        ResponseParam result = new ResponseParam<>();
        Product product = iProductService.queryById(pid);
        if(null != product){
            result.setRespInfo(product);
            return product;
        }else {
            result.setRespCode(ResponseStatusEnum.NODATA.getRespCode());
            result.setRespMsg(ResponseStatusEnum.NODATA.getRespMsg());
            throw  new  RuntimeException("ID=" + pid + "无效");
            //return result;
        }

    }

    public Product queryByIdFallBack (@PathVariable("pid")Long pid){
        Product product = new Product(pid, "ID=" + pid + "无效---HystrixCommand","无法找到对应的数据");
        ResponseParam result = new ResponseParam<>();
        result.setRespCode(ResponseStatusEnum.NODATA.getRespCode());
        result.setRespMsg(ResponseStatusEnum.NODATA.getRespMsg());
        result.setRespInfo(product);
        return product;
    }


    @RequestMapping(value ="insertProduct",method = RequestMethod.POST)
    public ResponseParam<Integer> insertProduct(@RequestBody Product product){
        ResponseParam result = new ResponseParam<>();
        int i = iProductService.insertProduct(product);
        if(i > 0){
            return result;
        }
        result.setRespCode(ResponseStatusEnum.FAIL.getRespCode());
        result.setRespMsg(ResponseStatusEnum.FAIL.getRespMsg());
        return result;
    }

    @GetMapping(value ="deletePriductById/{pid}")
    public  ResponseParam<Integer> deletePriductById(@PathVariable("pid") Long pid){
        ResponseParam result = new ResponseParam<>();
        int i = iProductService.deletePriductById(pid);
        if(i > 0){
            return result;
        }
        result.setRespCode(ResponseStatusEnum.FAIL.getRespCode());
        result.setRespMsg(ResponseStatusEnum.FAIL.getRespMsg());
        return result;
    }
}
