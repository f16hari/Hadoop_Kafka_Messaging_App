package com.f16hari.hadoop_kafka_server.messages;

public abstract class Message {

    private String topic;
    private String data;

    public Message(){
        
    }
    
    public void setTopic(String topic){
        this.topic = topic;
    }

    public void setData(String data){
        this.data = data;
    }

    public String getTopic(){
        return topic;
    }

    public String getData(){
        return data;
    }

    @Override
    public String toString() {
        return ("Topic : " + topic + " Data : " + data);
    }
}

