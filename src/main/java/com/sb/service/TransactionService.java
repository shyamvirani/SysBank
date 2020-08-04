package com.sb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sb.exception.AccountNotFoundException;
import com.sb.exception.InsufficientBalanceException;
import com.sb.model.Account;
import com.sb.model.Transaction;
import com.sb.repository.TransactionRepository;
import static java.time.Instant.now;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.exception.CustomerNotFoundException;
import com.sb.model.Customer;
import com.sb.repository.CustomerRepository;


@Service
public class TransactionService {

	@Autowired
	private AccountService accountService;

	@Autowired
	private TransactionRepository transactionRepository;

	@Transactional
	public String createTransaction(Transaction transaction) {

		Account fromAccount = accountService.getAccount(transaction.getFromAccount().getAccountId());
		Account toAccount = accountService.getAccount(transaction.getFromAccount().getAccountId());

		if (fromAccount == null || toAccount==null) {
			throw new AccountNotFoundException(
					"account not found " + transaction.getFromAccount().getAccountId());
		
		} else if (fromAccount.getBalance() < transaction.getAmount()) {
			throw new InsufficientBalanceException("Trnsaction fail ,low balance!!");
		} else {
			transaction.setTransactionDate(now().plusMillis(19800000));
			fromAccount.setBalance(fromAccount.getBalance() - transaction.getAmount());
			toAccount.setBalance(toAccount.getBalance() + transaction.getAmount());
			accountService.updateAccount(fromAccount);
			accountService.updateAccount(toAccount);
			transactionRepository.save(transaction);
			return "Amount transfer completed successfully";
		}
	}
	
	public List<Transaction> getTransactionByAccount(Account id){
		return transactionRepository.findByfromAccount(id);
		
	}
	/*
	 * public List<Transaction> listTransaction(Instant startDate, Instant endDate)
	 * { return transactionRepository.findAllByTransactionBetween(startDate,
	 * endDate); }
	 */

}
