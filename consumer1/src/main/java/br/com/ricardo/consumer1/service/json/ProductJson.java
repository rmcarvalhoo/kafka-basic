package br.com.ricardo.consumer1.service.json;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductJson {
    private String id;
    private String name;
    private BigDecimal price;
}
