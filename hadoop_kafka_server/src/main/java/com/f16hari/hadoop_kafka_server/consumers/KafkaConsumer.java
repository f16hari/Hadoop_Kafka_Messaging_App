package com.f16hari.hadoop_kafka_server.consumers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

public class KafkaConsumer implements Consumer{

    private static HashMap<String, KafkaConsumer> instances = new HashMap<>();

    public KafkaConsumerConfigProvider configProvider;
    public org.apache.kafka.clients.consumer.Consumer<String, String> consumer;

    KafkaConsumer(String groupName){
        configProvider = KafkaConsumerConfigProvider.getInstance(groupName);
        consumer = new org.apache.kafka.clients.consumer.KafkaConsumer<String, String>(configProvider.properties);
    }

    public static KafkaConsumer getInstance(String groupName){
        if(instances.containsKey(groupName)) return instances.get(groupName);

        KafkaConsumer instance = new KafkaConsumer(groupName);
        instances.put(groupName, instance);

        return instance;
    }

    public List<String> receive(String topic){
        consumer.subscribe(Collections.singleton(topic));

        ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));

        List<String> messages = new ArrayList<>();
        for(ConsumerRecord<String, String> record : records){
            messages.add(record.value());
        }

        return messages;
    }
}
