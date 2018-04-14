package com.roni.kafka.producer;

import java.util.Map;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

public class KafkaProducerPartitioner implements Partitioner {

    public void configure(Map<String, ?> configs) {
        // TODO Auto-generated method stub

    }

    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        return Integer.parseInt(key.toString());
    }

    public void close() {
        // TODO Auto-generated method stub

    }

}
