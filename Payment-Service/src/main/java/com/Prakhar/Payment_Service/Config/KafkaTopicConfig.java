package com.Prakhar.Payment_Service.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic paymentTopic() {
        // Topic ka naam: "payment-events"
        // Partitions: 3 (Parallel processing ke liye standard)
        // Replicas: 1 (Kyunki humare paas single Kafka broker hai)
        return TopicBuilder.name("payment-events")
                .partitions(3)
                .replicas(1)
                .build();
    }
}

