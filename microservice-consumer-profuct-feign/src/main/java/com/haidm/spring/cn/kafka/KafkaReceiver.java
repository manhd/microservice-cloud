package com.haidm.spring.cn.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @ClassName KafkaReceiver
 * @Description TODO
 * @Author sh-manhd
 * @Date 2019/6/20 16:44
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "kafka")
public class KafkaReceiver {

    private final Logger log = LoggerFactory.getLogger(getClass());


    @GetMapping(value = "receive")
    @KafkaListener(topics = {"kafkaSend"})
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {

            Object message = kafkaMessage.get();

            log.info("----------------- record =" + record);
            log.info("------------------ message =" + message);
        }

    }
}
