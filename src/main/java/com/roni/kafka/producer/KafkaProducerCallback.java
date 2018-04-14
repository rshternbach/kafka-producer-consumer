package com.roni.kafka.producer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

public class KafkaProducerCallback implements Callback {

    public void onCompletion(RecordMetadata metadata, Exception exception) {
       if (metadata!=null && exception == null) {
           System.out.println("message sent succesfully on topic: " +metadata.topic()+ " partition: " +metadata.partition() + " timestamp: " + metadata.timestamp());
       }
       else {
           System.out.println(exception.getMessage());
       }
        
    }

}
