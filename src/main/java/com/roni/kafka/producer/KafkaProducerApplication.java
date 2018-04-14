package com.roni.kafka.producer;

import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaProducerApplication {

    public static void main(String[] args) {
        startAsyncProducers(3);

    }
    
    private static void startAsyncProducers(int numberOfProducers) {
        for (int i = 0; i<numberOfProducers; i++) {
            String key = String.valueOf(i);
            KafkaProducerMessage messages[] = {new KafkaProducerMessage(key,"hello","first_topic"), new KafkaProducerMessage(key,"world","first_topic"),new KafkaProducerMessage(key,"this","first_topic"),new KafkaProducerMessage(key,"is","first_topic"), new KafkaProducerMessage(key,"kafka","first_topic")};
            KafkaProducerWorker producer = new KafkaProducerWorker(new KafkaProducerProperties("127.0.0.1:9092",
                    StringSerializer.class.getName(), StringSerializer.class.getName(), 1, 3, 0));
            producer.addMessages(messages);
            producer.start();
        }
    }

}
