
package com.example.demo.service;



import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.CustomerRepository;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Customer;



@Service
public class CustomerService implements ICustomerService {

   @Autowired
   private CustomerRepository customerRepository;
 
   @Autowired
   private ModelMapper modelMapper;



   @Override
   public List<CustomerDTO> getAllCustomers() {
       List<Customer> customers = customerRepository.findAll();
       return customers.stream()
                       .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                       .collect(Collectors.toList());
   }

  
}
