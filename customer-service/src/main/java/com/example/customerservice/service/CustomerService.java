package com.example.customerservice.service;

import com.example.customerservice.dto.CustomerRequestDTO;
import com.example.customerservice.dto.CustomerResponseDTO;
import com.example.customerservice.entities.Customer;
import com.example.customerservice.mapper.CustomerMapper;
import com.example.customerservice.repositories.CustomerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CustomerService implements ICustomerService{
    private CustomerRepo customerRepo;
    private CustomerMapper customerMapper;

    public List<CustomerResponseDTO> findAllCustomers(){
        List<Customer> customers = customerRepo.findAll();
        List<CustomerResponseDTO> customerResponseDTOS= new ArrayList<>();
        customers.forEach(c->{
            CustomerResponseDTO customerResponseDTO = customerMapper.customerToCustomerResponseDTO(c);
            customerResponseDTOS.add(customerResponseDTO);
        });
        return customerResponseDTOS;
    }

    @Override
    public CustomerResponseDTO findCustomerById(Long id) {
        Customer customer = customerRepo.findById(id).orElseThrow(()->new RuntimeException("Customer not found"));
        CustomerResponseDTO customerResponseDTO = customerMapper.customerToCustomerResponseDTO(customer);
        return customerResponseDTO;
    }

    @Override
    public CustomerResponseDTO saveCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerMapper.customerRequestDTOToCustomer(customerRequestDTO);
        Customer savedCustomer = customerRepo.save(customer);
        CustomerResponseDTO customerResponseDTO = customerMapper.customerToCustomerResponseDTO(savedCustomer);
        return customerResponseDTO;
    }
}
