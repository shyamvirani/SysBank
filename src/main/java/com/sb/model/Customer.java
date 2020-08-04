package com.sb.model;


import java.time.Instant;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long customerId;
	@Column(name="customer_ssn")
	private Long customerSSN;

	private String customerName;

	private String address;
	
	private String city;

	private int age;

	private String customerStatus;
	
	private Instant updatedOn;

	public Customer(Long customerId) {
		super();
		this.customerId = customerId;
	}
	
	


}
