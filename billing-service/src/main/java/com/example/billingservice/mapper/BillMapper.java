package com.example.billingservice.mapper;

import com.example.billingservice.dto.BillRequestDTO;
import com.example.billingservice.dto.BillResponseDTO;
import com.example.billingservice.entities.Bill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BillMapper {
    BillResponseDTO billToBillResponseDTO (Bill customer);
    Bill billRequestDTOToBill (BillRequestDTO customerRequestDTO);
}
