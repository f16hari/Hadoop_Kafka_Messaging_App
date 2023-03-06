package com.f16hari.hadoop_kafka_server.producers;

import java.util.Properties;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaProducerConfigProvider {
    private static KafkaProducerConfigProvider instance = null;

    public Properties producerProperties = new Properties();

    public KafkaProducerConfigProvider() {
        producerProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    }

    public static KafkaProducerConfigProvider getInstance(){
        
        if(instance != null) return instance;

        instance = new KafkaProducerConfigProvider();

        return instance;
    }
}
