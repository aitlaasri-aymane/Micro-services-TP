package com.example.billingservice.web;

import com.example.billingservice.dto.BillRequestDTO;
import com.example.billingservice.dto.BillResponseDTO;
import com.example.billingservice.service.BillingServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class BillingRestController {
    private BillingServiceImpl billingService;

    @GetMapping("/bill/{id}")
    public BillResponseDTO getBillById(@PathVariable Long id){
        return billingService.getBillByID(id);
    }

    @PostMapping("/bill")
    public BillResponseDTO saveBill(@RequestBody BillRequestDTO billRequestDTO){
        return billingService.saveBill(billRequestDTO);
    }
}
