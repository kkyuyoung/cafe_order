package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@Table(name = "CUSTOMER")
@ToString
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUSTOMER_NO", unique=true, nullable = false)
	private Long customerNo;

	@Column(name = "CUSTOMER_ID", nullable = false, length=100)
	private String customerId;
	
	@Column(name = "CUSTOMER_PW", nullable = false, length=200)
	private String customerPw;

	@Column(name = "CUSTOMER_NAME", nullable = false, length=100)
	private String customerName;
	
	@Column(name = "TEL", nullable = false, length=20)
	private String tel;
	
	@Column(name = "BIRTH", nullable = false, columnDefinition = "char(8)")
	private String birth;
	
	@Column(name = "GENDER", nullable = false, columnDefinition = "char(1)")
	private String gender;
	
}
