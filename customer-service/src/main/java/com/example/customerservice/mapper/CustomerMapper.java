package com.example.customerservice.mapper;

import com.example.customerservice.dto.CustomerRequestDTO;
import com.example.customerservice.dto.CustomerResponseDTO;
import com.example.customerservice.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring") // needs the mavencompiler plugin and the dependency
public interface CustomerMapper {
    CustomerResponseDTO customerToCustomerResponseDTO (Customer customer);
    Customer customerRequestDTOToCustomer (CustomerRequestDTO customerRequestDTO);
}
