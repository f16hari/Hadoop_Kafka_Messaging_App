package com.f16hari.hadoop_kafka_server.producers;

import org.apache.kafka.clients.producer.ProducerRecord;
import com.f16hari.hadoop_kafka_server.messages.Message;

public class KafkaProducer implements Producer{

    private static KafkaProducer instance = null;

    public KafkaProducerConfigProvider configProvider;
    private org.apache.kafka.clients.producer.Producer<String, String> producer;

    public KafkaProducer(){
        configProvider = KafkaProducerConfigProvider.getInstance();
        producer = new org.apache.kafka.clients.producer.KafkaProducer<>(configProvider.producerProperties);
    }

    public static KafkaProducer getInstance(){
        if(instance != null) return instance;

        instance = new KafkaProducer();
        return instance;
    }

    public void send(Message message){
        ProducerRecord<String, String> record = new ProducerRecord<String,String>(message.getTopic(), null, message.getData());

        producer.send(record);
        producer.flush();
    }
}
