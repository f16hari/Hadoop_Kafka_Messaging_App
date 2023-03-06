package com.f16hari.hadoop_kafka_server.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.f16hari.hadoop_kafka_server.messages.KafkaMessage;
import com.f16hari.hadoop_kafka_server.producers.KafkaProducer;
import com.f16hari.hadoop_kafka_server.producers.Producer;

@RestController
public class KafkaProducerController {

    @PostMapping("/Producer/Kafka/send")
    public void sendMessage(@RequestBody KafkaMessage message){
        Producer producer = KafkaProducer.getInstance();
        producer.send(message);
    }
}
