package com.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.model.Account;
import com.sb.model.Transaction;
import com.sb.service.TransactionService;

@RestController
@RequestMapping("/api")
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/transaction/{id}")
	public List<Transaction> getAllTransactionByAccount(@PathVariable("id") Account id) {

		return transactionService.getTransactionByAccount(id);

	}

}
