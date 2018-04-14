package com.roni.kafka.consumer;

import java.util.Arrays;

import org.apache.kafka.common.serialization.StringDeserializer;

import com.roni.kafka.consumer.KafkaConsumerProperties.AutoOffsetResetProperty;

public class KafkaConsumerApplication {

    public static void main(String[] args) {
        startAsyncConsumers("first_topic", 3);
    }
    
    private static void startAsyncConsumers(String topic, int numberOfConsumers) {
        for (int i = 0; i<numberOfConsumers; i++) {
            KafkaConsumerWorker consumer = new KafkaConsumerWorker(
                    new KafkaConsumerProperties("127.0.0.1:9092", StringDeserializer.class.getName(),
                            StringDeserializer.class.getName(), "test", true, 1000, AutoOffsetResetProperty.earliest),
                    Arrays.asList(topic));

            consumer.start();
        }
    }

}
