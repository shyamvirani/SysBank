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

import com.sb.model.Account;
import com.sb.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountController {
	
	@Autowired
	private AccountService accountService;

    @PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/createaccount")
	public ResponseEntity<Account> createAccount(@RequestBody Account account){
		return ResponseEntity.ok(accountService.createAccount(account));
		
	}
    @PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/account/{id}")
	public ResponseEntity<Account> getAccount(@PathVariable("id") Long id){
		return ResponseEntity.ok(accountService.getAccount(id));
	}
    @PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/account")
	public List<Account> getAllAccount(){
		return accountService.getAllAccount();
	}
    @PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/account")
	public ResponseEntity<Account> updateAccount(@RequestBody Account account){
		return ResponseEntity.ok(accountService.updateAccount(account));
	}
    @PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/account/{id}")
	public void deactivateAccount(@PathVariable("id") Long id){
		accountService.deactivateAccount(id);
	}
    @PreAuthorize("hasRole('CUSTOMER')")
	@PutMapping("/account/deposit")
	public String  depositAmount(@RequestBody Account account){
		return accountService.depositAmount(account);
	

	}
    @PreAuthorize("hasRole('CUSTOMER')")
	@PutMapping("/account/withdraw")
	public String withdrawAmount(@RequestBody Account account){
		return accountService.withdrawAmount(account);
	
	}
	
	
	
	

}
