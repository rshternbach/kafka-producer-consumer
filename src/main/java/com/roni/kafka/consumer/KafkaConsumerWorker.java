package com.roni.kafka.consumer;

import java.util.Collection;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class KafkaConsumerWorker extends Thread {

    private Consumer<String, String> consumer;

    public KafkaConsumerWorker(KafkaConsumerProperties properties, Collection<String> topics) {
        consumer = new KafkaConsumer<String, String>(properties.getProperties());
        consumer.subscribe(topics);
    }

    private void consumeMessages() {
        ConsumerRecords<String, String> consumerRecords = consumer.poll(100);
        for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
            System.out.println("consumer: " + Thread.currentThread().getName() + " partition: "
                    + consumerRecord.partition() + " offset: " + consumerRecord.offset()
                    + " key: " + consumerRecord.key() + " value: " + consumerRecord.value());
        }
    }

    private void shutdown() {
        if (consumer != null) {
            consumer.close();
        }
    }

    @Override
    public void run() {
        System.out.println("Consumer Thread id: " + Thread.currentThread().getId() + " name: "
                + Thread.currentThread().getName() + " has started listening");
        while (!Thread.currentThread().isInterrupted()) {
            consumeMessages();
        }
        shutdown();
        System.out.println("kafka consumer Thread id: " + Thread.currentThread().getId() + " name: "
                + Thread.currentThread().getName() + " has been stopped");
    }
    

}