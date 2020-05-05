package com.example.demo.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "ORDER_MENU")
@Getter
@NoArgsConstructor( access = AccessLevel.PUBLIC )
@ToString(exclude = { "menu", "order" })
public class OrderMenu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_MENU_NO", unique = true, nullable = false)
	private Long orderMenuNo;

	@Column(name = "MENU_NO")
	private Long menuNo;

	@Column(name = "ORDER_NO")
	private Long orderNo;

	@Column(name = "ORDER_COUNT", nullable = false)
	private Integer orderCount;

	@Column(name = "ORDER_PRICE", nullable = false)
	private Integer orderPrice;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MENU_NO", insertable = false, updatable = false)
	private Menu menu;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDER_NO", insertable = false, updatable = false)
	private Order order;

	@Builder
	public OrderMenu(Long orderMenuNo, Long menuNo, Long orderNo, Integer orderCount, Integer orderPrice) {
		this.orderMenuNo = orderMenuNo;
		this.menuNo = menuNo;
		this.orderNo = orderNo;
		this.orderCount = orderCount;
		this.orderPrice = orderPrice;
	}

}