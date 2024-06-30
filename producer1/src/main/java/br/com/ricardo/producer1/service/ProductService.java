package br.com.ricardo.producer1.service;

import br.com.ricardo.producer1.resource.json.ProductJson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private final KafkaTemplate<String, ProductJson> kafkaTemplate;

    public ProductJson create(ProductJson json) {
        CompletableFuture<SendResult<String, ProductJson>> result = kafkaTemplate.send("product-topic",  json.getId(), json);
        result.handleAsync((data, ex) -> {
            if (result != null) {
                log.info("Sending msg [{}] for product-topic {} ::: partition {} ::: offset {} ::: timestamp {}",
                        json,
                        data.getRecordMetadata().topic(),
                        data.getRecordMetadata().partition(),
                        data.getRecordMetadata().offset(),
                        data.getRecordMetadata().timestamp());
            } else if (ex != null) {
                log.error("Erro to send msg [{}] for product-topic", json, ex);
            }
            return null;
        });
        return json;
    }
}
