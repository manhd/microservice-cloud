package com.haidm.spring.cn.entities;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Product
 * @Description TODO
 * @Author sh-manhd
 * @Date 2019/5/21 14:59
 * @Version 1.0
 **/
@Data
public class Product implements Serializable {

    //商品ID
    private Long pid;
    //商品名称
    private String productName;
    //数据库源
    private String dbSource;

    public Product(Long pid, String productName, String dbSource) {
        this.pid = pid;
        this.productName = productName;
        this.dbSource = dbSource;
    }

    public Product() {
    }
}
