
package com.example.demo.service;



import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.exception.ResourceNotFoundException;
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

    @Override
    public CustomerDTO getCustomerById(Integer customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id "+customerId+" is not found"));
        return modelMapper.map(customer, CustomerDTO.class);
    }
    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        Customer updatedCustomer = customerRepository.save(customer);
        return modelMapper.map(updatedCustomer, CustomerDTO.class);
    }
    @Override
    public void deleteCustomer(Integer customerId) {
        if (customerRepository.existsById(customerId)) {
            customerRepository.deleteById(customerId);
        } else {
            throw new  ResourceNotFoundException("Customer with id "+customerId+" is not found");
        }
    }




}
