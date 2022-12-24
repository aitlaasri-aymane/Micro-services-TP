package com.example.billingservice.models;

import lombok.Data;
import lombok.ToString;

@Data @ToString
public class Customer { // same as the class from the customer service
    private Long id;
    private String name;
    private String email;
}
