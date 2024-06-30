package br.com.ricardo.producer1.resource;

import br.com.ricardo.producer1.resource.json.ProductJson;
import br.com.ricardo.producer1.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductResource {

    @Autowired
    private ProductService service;

    @PostMapping("/")
    public ResponseEntity<String> create(@RequestBody ProductJson product) {
        log.info("Creating product {}", product);
        product.setId(UUID.randomUUID().toString());
        service.create(product);
        return ResponseEntity.ok().body("SUCESSO");
    }

}
