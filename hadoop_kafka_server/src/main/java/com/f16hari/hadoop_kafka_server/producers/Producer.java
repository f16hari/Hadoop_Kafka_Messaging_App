package com.f16hari.hadoop_kafka_server.producers;

import com.f16hari.hadoop_kafka_server.messages.Message;

public interface Producer {
    void send(Message message);
}
