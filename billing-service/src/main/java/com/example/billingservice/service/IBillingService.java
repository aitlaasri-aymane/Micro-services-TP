package com.example.billingservice.service;

import com.example.billingservice.dto.BillRequestDTO;
import com.example.billingservice.dto.BillResponseDTO;

public interface IBillingService {
    BillResponseDTO getBillByID(Long id);
    BillResponseDTO saveBill(BillRequestDTO billRequestDTO);
}
