package com.example.billingservice.dto;

import com.example.billingservice.entities.ProductItem;
import com.example.billingservice.models.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillResponseDTO {
    private Long id;
    private Date billingDate;
    private Double amount;
    private Collection<ProductItemResponseDTO> productItems;
    private Customer customer;
}
