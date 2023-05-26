package cn.netbuffer.sbkd.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("getDefaultTopic")
    public String getDefaultTopic() {
        return kafkaTemplate.getDefaultTopic();
    }

    @GetMapping("getTransactionIdPrefix")
    public String getTransactionIdPrefix() {
        return kafkaTemplate.getTransactionIdPrefix();
    }

    @GetMapping("getMessageConverter")
    public String getMessageConverter() {
        return kafkaTemplate.getMessageConverter().toString();
    }

    @GetMapping("send")
    public void getMessageConverter(String topic, String data) {
        ListenableFuture listenableFuture = kafkaTemplate.send(topic, data);
        listenableFuture.addCallback(new ListenableFutureCallback<SendResult>() {
            @Override
            public void onSuccess(SendResult result) {
                ProducerRecord producerRecord = result.getProducerRecord();
                RecordMetadata recordMetadata = result.getRecordMetadata();
                log.debug("send message[{}] to topic[{}][{}]", producerRecord.value(), producerRecord.topic(), producerRecord.partition());
                log.debug("recordMetadata topic[{}][{}][{}]", producerRecord.topic(), producerRecord.partition(), recordMetadata.offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error("send message error:", ex);
            }
        });
    }

}