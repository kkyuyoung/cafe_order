package com.example.demo.domain;

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
@Table(name = "ORDER_MENU")
@ToString
public class OrderMenu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_MENU_NO", unique = true, nullable = false)
	private Long orderMenuNo;
	
	@Column(name = "MENU_NO")
	private Long menuNo;

	@Column(name = "ORDER_COUNT", nullable = false)
	private Integer orderCount;
	
	@Column(name = "ORDER_PRICE", nullable = false)
	private Integer orderPrice;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="MENU_NO", insertable = false, updatable = false)
	private Menu menu;
	
}