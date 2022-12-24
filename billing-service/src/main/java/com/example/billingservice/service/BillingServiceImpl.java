package com.example.billingservice.service;

import com.example.billingservice.dto.BillRequestDTO;
import com.example.billingservice.dto.BillResponseDTO;
import com.example.billingservice.dto.ProductItemResponseDTO;
import com.example.billingservice.entities.Bill;
import com.example.billingservice.entities.ProductItem;
import com.example.billingservice.feign.CustomerService;
import com.example.billingservice.feign.ProductItemService;
import com.example.billingservice.mapper.BillMapper;
import com.example.billingservice.mapper.ProductItemMapper;
import com.example.billingservice.repositories.BillRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;

@Service
@Transactional
@AllArgsConstructor
public class BillingServiceImpl implements IBillingService {
    private BillRepo billRepo;
    private CustomerService customerService;
    private ProductItemService productItemService;
    private BillMapper billMapper;
    private ProductItemMapper productItemMapper;

    @Override
    public BillResponseDTO getBillByID(Long id) {
        Bill bill = billRepo.findById(id).orElseThrow(()->new RuntimeException("Bill "+id+" not found"));
        bill.setCustomer(customerService.getCustomerById(bill.getCustomerID()));
        BillResponseDTO billResponseDTO = billMapper.billToBillResponseDTO(bill);
        billResponseDTO.setAmount(0.0);
        billResponseDTO.setProductItems(new ArrayList<>());
        bill.getProductItems().forEach(productItem->{
            //productItem.setProduct(productItemService.getProductById(productItem.getProductID()));
            productItem.setProductName(productItemService.getProductById(productItem.getProductID()).getName());
            ProductItemResponseDTO productItemResponseDTO = productItemMapper.productItemToProductItemResponseDTO(productItem);
            billResponseDTO.getProductItems().add(productItemResponseDTO);
            billResponseDTO.setAmount(billResponseDTO.getAmount() + productItem.getPrice());
        });
        return billResponseDTO;
    }

    @Override
    public BillResponseDTO saveBill(BillRequestDTO billRequestDTO) {
        Bill bill = billMapper.billRequestDTOToBill(billRequestDTO);
        bill.setCustomerID(billRequestDTO.getCustomerID());
        bill.setCustomer(customerService.getCustomerById(billRequestDTO.getCustomerID()));
        bill.setBillingDate(new Date());
        Bill savedBill = billRepo.save(bill);
        return billMapper.billToBillResponseDTO(savedBill);
    }
}
