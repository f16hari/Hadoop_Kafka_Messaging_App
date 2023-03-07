package com.f16hari.hadoop_kafka_server.consumers;

import java.util.List;

public interface Consumer {
    List<String> receive(String topic);
}
