package com.example.demo.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@Table(name = "ORDER")
@ToString
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_NO", unique = true, nullable = false)
	private Long orderNo;
	
	@Column(name = "CUSTOMER_NO")
	private Long customerNo;

	@Column(name = "ORDER_DATE", nullable = false)
	private LocalDateTime orderDate;

	@Column(name = "ALL_ORDER_COUNT", nullable = false)
	private Integer allOrderCount;
	
	@Column(name = "ALL_ORDER_PRICE", nullable = false)
	private Integer allOrderPrice;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CUSTOMER_NO", insertable = false, updatable = false)
	private Customer customer;
	
}