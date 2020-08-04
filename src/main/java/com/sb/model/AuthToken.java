package com.sb.model;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthToken {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long tokenId;
	private String token;

	@OneToOne(fetch = LAZY)
	private User user;

	public AuthToken(String token) {
		this.token = token;
	}

}
