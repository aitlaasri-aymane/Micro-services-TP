package com.example.billingservice.entities;

import com.example.billingservice.models.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;
    private Long quantity;
    private Long productID;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Bill bill;
    @Transient // no need for the OnetoMany or anything
    @JsonIgnore // fasterxml package
    private Product product;
    @Transient
    private String productName;
}
