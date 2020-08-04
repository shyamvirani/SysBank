package com.sb.model;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Loan {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long loanId;
	
	private String loanType;
	
	private long loanAmount;
	
	@ManyToOne
	@JoinColumn(name = "fk_customer_id",nullable = false)
	private Customer customer;
	
	

}
