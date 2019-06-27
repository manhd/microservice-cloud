package com.haidm.spring.cn.kafka;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.haidm.spring.cn.entities.Product;
import com.haidm.spring.cn.response.ResponseParam;
import com.haidm.spring.cn.response.enums.ResponseStatusEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName KafkaKafkaSender
 * @Description TODO
 * @Author sh-manhd
 * @Date 2019/6/20 16:34
 * @Version 1.0
 **/
@RestController
@RequestMapping("kafka")
public class KafkaKafkaSender {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private Gson gson = new GsonBuilder().create();

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @GetMapping(value = "send")
    public ResponseParam send(){
        ResponseParam result = new ResponseParam();

        Product product = new Product();
        product.setPid(Long.valueOf("55555"));
        product.setProductName("kafka测试");
        product.setDbSource("kafka测试库");
        log.info("+++++++++++++++++++++  message = {}", gson.toJson(product));

        try {
            kafkaTemplate.send("kafkaSend",gson.toJson(product));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setRespCode(ResponseStatusEnum.FAIL.getRespCode());
            result.setRespMsg(ResponseStatusEnum.FAIL.getRespMsg());
            return result;
        }
    }
}
