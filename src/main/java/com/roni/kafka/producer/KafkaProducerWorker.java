package com.roni.kafka.producer;

import java.util.Stack;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaProducerWorker extends Thread {

    private Producer<String, String> producer;

    private Stack<KafkaProducerMessage> messages;

    public void addMessages(KafkaProducerMessage[] messages) {
        for (KafkaProducerMessage message : messages) {
            this.messages.push(message);
        }
    }

    public KafkaProducerWorker(KafkaProducerProperties properties) {
        producer = new KafkaProducer<String, String>(properties.getProperties());
        messages = new Stack<KafkaProducerMessage>();
    }

    private void publishMessage(KafkaProducerMessage message) {
        ProducerRecord<String, String> producerRecord;
        if (message.getId() != null && !message.getId().isEmpty()) {
            producerRecord = new ProducerRecord<String, String>(message.getTopic(), message.getId(),
                    message.getMessage());
        } else {
            producerRecord = new ProducerRecord<String, String>(message.getTopic(), message.getMessage());
        }
        producer.send(producerRecord, new KafkaProducerCallback());
    }

    private void publishMessages() {
        while (!messages.isEmpty()) {
            publishMessage(messages.pop());
        }

    }

    @Override
    public void run() {
        System.out.println("Producer Thread id: " + Thread.currentThread().getId() + " name: "
                + Thread.currentThread().getName() + " has started sending messages");
        while (!Thread.currentThread().isInterrupted()) {
            publishMessages();
        }
        shutdown();
        System.out.println("kafka producer Thread id: " + Thread.currentThread().getId() + " name: "
                + Thread.currentThread().getName() + " has been stopped");
    }

    public void shutdown() {
        if (producer != null) {
            producer.close();
        }
    }
}
