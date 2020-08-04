package com.sb.service;

import static java.time.Instant.now;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.exception.CustomerNotFoundException;
import com.sb.model.Customer;
import com.sb.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	public Customer addCustomer(Customer customer){
		customer.setUpdatedOn(now().plusMillis(19800000));
		customer.setCustomerStatus("active");
		return customerRepository.save(customer);
	}
	public Customer getCustomer(Long id) {
		return customerRepository.findById(id)
				.orElseThrow(()-> new CustomerNotFoundException("customer not found"+id));
	}
    public String deactivateCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("customer not found with customerId : " + id));
        customer.setCustomerStatus("Deactive");
        customerRepository.save(customer);
        return "Customer successfully deactivated";
    }
    public Customer updateCustomer(Customer customer) {

        Customer existingCustomer = customerRepository.findById(customer.getCustomerId()).orElseThrow(() -> new CustomerNotFoundException("customer not found with customerId : " + customer.getCustomerId()));
        customer.setCustomerId(existingCustomer.getCustomerId());
        customer.setCustomerSSN(existingCustomer.getCustomerSSN());
        customer.setUpdatedOn(now().plusMillis(19800000));
        customer.setCustomerStatus(existingCustomer.getCustomerStatus());
        return customerRepository.save(customer);
    }
    
    public List<Customer> getAllCustomer(){
    	return customerRepository.findAll();
    }
	/*
	 * public String deleteCustomer(Long id) { Customer customer =
	 * customerRepository.findById(id).orElseThrow(() -> new
	 * CustomerNotFoundException("customer not found with customerId : " + id));
	 * customerRepository.deleteById(id);
	 * return "Successfully deleted"; }
	 */
	
	
	
	
}
