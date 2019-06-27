package com.haidm.spring.cn.controller;

import com.haidm.spring.cn.entities.Apple;
import com.haidm.spring.cn.mapper.AppleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName AppleController
 * @Description TODO
 * @Author sh-manhd
 * @Date 2019/6/17 13:34
 * @Version 1.0
 **/
@RestController
public class AppleController {

    @Autowired
    private AppleMapper appleMapper;


    @PostMapping(value = "apple/getApple")
    public List queryApple(@RequestBody Apple appleParam){





        List<Apple> list = appleMapper.appleList();

        List<Apple> collect = list.parallelStream().filter(apple -> apple.getColor().equals(appleParam.getColor())).collect(Collectors.toList());

        Map<String, List<Apple>> collect1 = list.parallelStream().collect(Collectors.groupingBy(Apple::getWeight));



        System.out.println("success");


        return collect;
    }

}
