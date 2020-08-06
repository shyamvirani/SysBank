package com.sb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.exception.LoanNotFoundException;
import com.sb.model.Customer;
import com.sb.model.Loan;
import com.sb.repository.LoanRepository;
@Service
public class LoanService {
	
	@Autowired
	private LoanRepository loanRepository;

	public Loan newLoan(Loan loan){
		return loanRepository.save(loan);
	}
	
	public List<Loan> findLoanOfCustomer(Customer id){
		return loanRepository.findLoanByCustomer(id);
	}
	public Loan findLoan(Long id){
		return loanRepository.findById(id).orElseThrow(()->new LoanNotFoundException("No loan with this loan id"+id));
	}
	
	
	
}
