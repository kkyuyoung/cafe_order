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
@Table(name = "MENU")
@ToString
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MENU_NO", unique=true, nullable = false)
	private Long menuNo;
	
	@Column(name = "CATEGORY_NO", unique=true, nullable = false)
	private Long categoryNo;

	@Column(name = "MENU_PRICE", nullable = false)
	private Integer menuPrice;

	@Column(name = "MENU_NAME", nullable = false, length=100)
	private String menuName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CATEGORY_NO", insertable = false, updatable = false)
	private MenuCategory menuCategory;

}
