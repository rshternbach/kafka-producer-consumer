package com.roni.kafka.producer;

public class KafkaProducerMessage {

    private String id;

    private String message;
    
    private String topic;

    public KafkaProducerMessage() {
    }

    public KafkaProducerMessage(String id, String message, String topic) {
        this.id = id;
        this.message = message;
        this.topic = topic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "KafkaProducerMessage [id=" + id + ", message=" + message + ", topic=" + topic + "]";
    }

}
