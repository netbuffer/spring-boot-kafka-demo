package cn.netbuffer.sbkd.component;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {

    @KafkaListener(groupId = "sbkd-group", topics = {"sbkd"})
    public void consumeForSbkd(ConsumerRecord<String, String> consumerRecord) {
        log.debug("receive consumerRecord={}", consumerRecord);
    }

}