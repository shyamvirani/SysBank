package com.sb.service;

import static java.time.Instant.now;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sb.exception.AccountNotFoundException;
import com.sb.exception.CustomerNotFoundException;
import com.sb.exception.InsufficientBalanceException;
import com.sb.model.Account;
import com.sb.model.Customer;
import com.sb.repository.AccountRepository;
import com.sb.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AccountService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AuthService authService;
	
	public Account createAccount(Account account) {
		if (!customerRepository.findById(account.getCustomer().getCustomerId()).isPresent()) {
			throw new CustomerNotFoundException(
					"Nocustomer with customer Id : " + account.getCustomer().getCustomerId());
		}
		account.setAccountCreatedOn(now().plusMillis(19800000));
		account.setAccountUpdatedOn(now().plusMillis(19800000));
		return accountRepository.save(account);
	}

	public Account getAccount(Long id) {
		return accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("account not found" + id));
	}

	public List<Account> getAllAccount() {
		return accountRepository.findAll();
	}

	@Transactional
	public String depositAmount(Account account) {
		Account existingAccount = accountRepository.findById(account.getAccountId())
				.orElseThrow(() -> new AccountNotFoundException("account not found  : " + account.getAccountId()));
		account.setAccountId(existingAccount.getAccountId());
		account.setAccountCreatedOn(existingAccount.getAccountCreatedOn());
		account.setAccountStatus(existingAccount.getAccountStatus());
		account.setAccountType(existingAccount.getAccountType());
		account.setCustomer(existingAccount.getCustomer());
		account.setAccountUpdatedOn(now().plusMillis(19800000));
		account.setBalance(existingAccount.getBalance() + account.getBalance());
		accountRepository.save(account);
		return "deposit amount successfully";

	}

	@Transactional
	public String withdrawAmount(Account account) {
		Account existingAccount = accountRepository.findById(account.getAccountId())
				.orElseThrow(() -> new AccountNotFoundException("account not found with : " + account.getAccountId()));

		if (existingAccount.getBalance() < account.getBalance()) {
			throw new InsufficientBalanceException("low balance");
		} else {
	

			if (existingAccount.getCustomer().getUser().getUsername()
					.equals(authService.getCurrentUser().getUsername())) {
				account.setAccountId(existingAccount.getAccountId());
				account.setAccountCreatedOn(existingAccount.getAccountCreatedOn());
				account.setAccountStatus(existingAccount.getAccountStatus());
				account.setAccountType(existingAccount.getAccountType());
				account.setCustomer(existingAccount.getCustomer());
				account.setAccountUpdatedOn(now().plusMillis(19800000));
				account.setBalance(existingAccount.getBalance() - account.getBalance());
				accountRepository.save(account);
				return "amount withdraw successfully";
			} else {
				return "cant withdraw";
			}
		}

	}

	public Account updateAccount(Account account) {
		Account existingAccount = accountRepository.findById(account.getAccountId())
				.orElseThrow(() -> new AccountNotFoundException("account not found  : " + account.getAccountId()));
		Customer customer = customerRepository.findById(account.getCustomer().getCustomerId())
				.orElseThrow(() -> new CustomerNotFoundException("customer not found"));
		log.info(customer.toString());
		account.setAccountId(existingAccount.getAccountId());
		account.setAccountUpdatedOn(now().plusMillis(19800000));
		account.setAccountCreatedOn(existingAccount.getAccountCreatedOn());
		account.setBalance(existingAccount.getBalance());
		account.setCustomer(customer);
		return accountRepository.save(account);
	}

	public String deactivateAccount(Long id) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException("customer not found with customerId : " + id));
		account.setAccountStatus("Deactivated");
		account.setAccountUpdatedOn(now().plusMillis(19800000));
		accountRepository.save(account);
		return "account successfully deactivated";
	}

}
