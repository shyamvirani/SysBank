package com.sb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.model.Account;
import com.sb.model.Customer;
import com.sb.model.User;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
