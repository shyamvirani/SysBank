package com.sb.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long accountId;
	
	@ManyToOne
	@JoinColumn(name="fk_customer_id")
	private Customer customer;
	
	private String accountType;
	
	private String accountStatus;
	
	private long balance;
	
	private Instant accountUpdatedOn;

	private Instant accountCreatedOn;

}
