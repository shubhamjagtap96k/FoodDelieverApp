package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CustomerDTO;


public interface ICustomerService {
 
//	public CustomerDTO saveCustomer(CustomerDTO customerDTO);
 
	public List<CustomerDTO> getAllCustomers();
	public CustomerDTO getCustomerById(Integer customerId);
	public CustomerDTO updateCustomer(CustomerDTO customerDTO);
	public void deleteCustomer(Integer customerId);

 
 
}
