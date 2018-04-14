package com.roni.kafka.producer;

import java.util.Properties;

public class KafkaProducerProperties {

    private Properties properties;

    public KafkaProducerProperties() {
    }

    public KafkaProducerProperties(String bootstrapServers, String keySerializer, String valueSerializer, int acks,
            int retries, int lingerMs) {
        properties = new Properties();
        properties.setProperty("bootstrap.servers", bootstrapServers);
        properties.setProperty("key.serializer", keySerializer);
        properties.setProperty("value.serializer", valueSerializer);
        properties.setProperty("acks", Integer.toString(acks));
        properties.setProperty("retries", Integer.toString(retries));
        properties.setProperty("linger.ms", Integer.toString(lingerMs));
        properties.setProperty("partitioner.class", KafkaProducerPartitioner.class.getName());
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

}
