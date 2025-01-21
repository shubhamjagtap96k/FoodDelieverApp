package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.service.ICustomerService;

 

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
 
    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerDTO> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }
    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Integer customerId) {
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return ResponseEntity.ok(customerDTO);
    }
    @PutMapping("/{customerId}")
    public String updateCustomer(@PathVariable Integer customerId, @RequestBody CustomerDTO customerDTO) {
        customerDTO.setCustomerId(customerId);
        CustomerDTO updatedCustomer = customerService.updateCustomer(customerDTO);
        return "Customer Updated succefully !!";  //ResponseEntity.ok(updatedCustomer);
    }
    

}
