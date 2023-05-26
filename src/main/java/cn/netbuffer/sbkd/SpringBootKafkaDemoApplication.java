package cn.netbuffer.sbkd;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@SpringBootApplication
public class SpringBootKafkaDemoApplication {

    @Bean
    public KafkaTemplate<String, String> buildStringTemplate(ProducerFactory<String, String> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("sbkd")
                .partitions(1)
                .replicas(0)
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKafkaDemoApplication.class, args);
    }

}
