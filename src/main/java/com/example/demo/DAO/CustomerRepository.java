package com.example.demo.DAO;

//
//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Customer;




@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
