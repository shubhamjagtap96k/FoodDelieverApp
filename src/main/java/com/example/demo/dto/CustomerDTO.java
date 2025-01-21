package com.example.demo.dto;

import com.example.demo.entity.DeliveryAddresses;
import lombok.Data;

import java.util.List;

@Data
public class CustomerDTO {
	private Integer customerId;
	private String customerName;
	private String customerEmail;
	private String customerPhone;
	private List<DeliveryAddresses> deliveryAddresses;
//	private String password;
	
 
}
                             
