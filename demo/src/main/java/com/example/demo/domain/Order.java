package com.example.demo.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "ORDERS")
@Getter
@NoArgsConstructor( access = AccessLevel.PUBLIC )
@ToString(exclude = { "customer", "orderMenuList" })
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
	@JoinColumn(name = "CUSTOMER_NO", insertable = false, updatable = false)
	private Customer customer;

	@OneToMany(mappedBy = "order")
	private List<OrderMenu> orderMenuList;

	@Builder
	public Order(Long orderNo, Long customerNo, LocalDateTime orderDate, Integer allOrderCount, Integer allOrderPrice) {
		this.orderNo = orderNo;
		this.customerNo = customerNo;
		this.orderDate = orderDate;
		this.allOrderCount = allOrderCount;
		this.allOrderPrice = allOrderPrice;
	}

}