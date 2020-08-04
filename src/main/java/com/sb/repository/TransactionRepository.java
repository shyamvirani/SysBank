package com.sb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.model.Account;
import com.sb.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	//List<Transaction> findAllByTransactionBetween(Instant startDate, Instant endDate);

	List<Transaction> findByfromAccount(Account account);

}
