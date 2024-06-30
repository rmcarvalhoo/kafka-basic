package br.com.ricardo.consumer1.service;

import br.com.ricardo.consumer1.service.json.ProductJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductService {

    @KafkaListener(topics = "product-topic", groupId = "grupo")
    public void consumer(@Payload ProductJson json) {
      log.info("Receveid the product {}", json);
    }

}
