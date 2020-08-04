package com.sb.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long transactionId;

	@ManyToOne
	@JoinColumn(name = "fk_source_account_id" ,nullable = false)
    private Account fromAccount;

	@ManyToOne
	@JoinColumn(name = "fk_target_account_id" ,nullable = false)
    private Account toAccount;

    private long amount;

    private String fromAccountType;

    private String toAccountType;

    private Instant transactionDate;

}
