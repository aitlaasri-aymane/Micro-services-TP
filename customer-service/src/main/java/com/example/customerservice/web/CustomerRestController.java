package com.example.customerservice.web;

import com.example.customerservice.dto.CustomerRequestDTO;
import com.example.customerservice.dto.CustomerResponseDTO;
import com.example.customerservice.entities.Customer;
import com.example.customerservice.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class CustomerRestController {
    CustomerService customerService;

    @GetMapping("/customers")
    public List<CustomerResponseDTO> customers(){
        return customerService.findAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public CustomerResponseDTO customers(@PathVariable Long id){
        return customerService.findCustomerById(id);
    }

    @PostMapping("/customers")
    public CustomerResponseDTO addCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){
        return customerService.saveCustomer(customerRequestDTO);
    }
}
