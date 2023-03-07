package com.f16hari.hadoop_kafka_server.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.f16hari.hadoop_kafka_server.consumers.Consumer;
import com.f16hari.hadoop_kafka_server.consumers.KafkaConsumer;

@RestController
public class KafkaConsumerController {

    @GetMapping("/Consumer/Kafka/receive")
    public List<String> sendMessage(@RequestParam String group, @RequestParam String topic){
        Consumer consumer = KafkaConsumer.getInstance(group);
        List<String> messages = consumer.receive(topic);

        return messages;
    }
}
