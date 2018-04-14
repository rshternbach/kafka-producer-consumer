package com.roni.kafka.consumer;

import java.util.Properties;

public class KafkaConsumerProperties {
    
    private Properties properties;
    
    public static enum AutoOffsetResetProperty {
        earliest,
        latest,
        none,
        anything;
    }
    
    public KafkaConsumerProperties() {        
    }
    
    public KafkaConsumerProperties(String bootstrapServers, String keyDeserializer, String valueDeserializer, String groupId, boolean enableAutoCommit, int autoCommitIntervalMs , AutoOffsetResetProperty autoOffsetReset ) {
        properties = new Properties();
        properties.setProperty("bootstrap.servers", bootstrapServers);
        properties.setProperty("key.deserializer", keyDeserializer);
        properties.setProperty("value.deserializer", valueDeserializer);
        properties.setProperty("group.id", groupId);
        properties.setProperty("enable.auto.commit",Boolean.toString(enableAutoCommit));
        properties.setProperty("auto.commit.interval.ms", Integer.toString(autoCommitIntervalMs));
        properties.setProperty("auto.offset.reset", autoOffsetReset.name());
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

}
