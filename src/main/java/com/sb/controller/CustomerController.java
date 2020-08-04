package com.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.model.Customer;
import com.sb.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/addcustomer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
    	return ResponseEntity.ok(customerService.addCustomer(customer));
    }
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/customer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.updateCustomer(customer));
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id){
        return ResponseEntity.ok(customerService.getCustomer(id));
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/allcustomer")
    public ResponseEntity<List<Customer>> getAllCustomer(){
    	return ResponseEntity.ok(customerService.getAllCustomer());
    }
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/customer/{id}")
    public String deleteCustomer(@PathVariable("id") Long id){
        customerService.deactivateCustomer(id);
        return "customer deactivated";
    }
	
}
