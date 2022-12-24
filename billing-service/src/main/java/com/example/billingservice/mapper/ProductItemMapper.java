package com.example.billingservice.mapper;

import com.example.billingservice.dto.BillResponseDTO;
import com.example.billingservice.dto.ProductItemResponseDTO;
import com.example.billingservice.entities.Bill;
import com.example.billingservice.entities.ProductItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductItemMapper {
    ProductItemResponseDTO productItemToProductItemResponseDTO (ProductItem productItem);
}
