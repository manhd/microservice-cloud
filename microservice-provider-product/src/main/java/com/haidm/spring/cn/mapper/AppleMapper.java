package com.haidm.spring.cn.mapper;

import com.haidm.spring.cn.entities.Apple;
import com.haidm.spring.cn.entities.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AppleMapper {



    Apple queryById(String id);

    List<Apple> appleList();


}
