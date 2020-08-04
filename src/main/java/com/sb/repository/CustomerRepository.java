package com.sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
