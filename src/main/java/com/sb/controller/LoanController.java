package com.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.model.Customer;
import com.sb.model.Loan;
import com.sb.service.LoanService;

@RestController
@RequestMapping("/api")
public class LoanController {
	@Autowired
	private LoanService loanService;

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/newloan")
	public ResponseEntity<Loan> newLoan(@RequestBody Loan loan) {
		return ResponseEntity.ok(loanService.newLoan(loan));
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/loanofcustomer/{id}")
	public ResponseEntity<List<Loan>> loanByCustomer(@PathVariable("id") Customer id) {
		return ResponseEntity.ok(loanService.findLoanOfCustomer(id));
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/loanofcustomer/{id}")
	public ResponseEntity<Loan> findLoan(@PathVariable("id") Long id) {
		return ResponseEntity.ok(loanService.findLoan(id));
	}

}
