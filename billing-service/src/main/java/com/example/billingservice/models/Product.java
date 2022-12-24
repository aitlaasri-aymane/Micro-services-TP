package com.example.billingservice.models;

import lombok.Data;
import lombok.ToString;

@Data @ToString
public class Product { // same as the class from the inventory service
    private Long id;
    private String name;
    private Double price;
    private Long quantity;
}
