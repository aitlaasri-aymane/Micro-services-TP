package com.example.customerservice.service;

import com.example.customerservice.dto.CustomerRequestDTO;
import com.example.customerservice.dto.CustomerResponseDTO;

import java.util.List;

public interface ICustomerService {
    public List<CustomerResponseDTO> findAllCustomers();
    public CustomerResponseDTO findCustomerById(Long id);
    public CustomerResponseDTO saveCustomer(CustomerRequestDTO customerRequestDTO);
}
