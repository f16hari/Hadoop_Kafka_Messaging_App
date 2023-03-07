package com.f16hari.hadoop_kafka_server.consumers;

import java.util.HashMap;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;

public class KafkaConsumerConfigProvider {
    private static HashMap<String, KafkaConsumerConfigProvider> instances = new HashMap<>();

    public Properties properties = new Properties();

    KafkaConsumerConfigProvider(String groupName){
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, groupName);

        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
    }

    public static KafkaConsumerConfigProvider getInstance(String groupName){
        if(instances.containsKey(groupName)) return instances.get(groupName);

        KafkaConsumerConfigProvider instance = new KafkaConsumerConfigProvider(groupName);
        instances.put(groupName, instance);

        return instance;
    }
}

