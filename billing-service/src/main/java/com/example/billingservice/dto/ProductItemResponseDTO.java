package com.example.billingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductItemResponseDTO {
    private Long id;
    private Double price;
    private Long quantity;
    private String productName;
}
