package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@Table(name = "MENU_CATEGORY")
@ToString
public class MenuCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CATEGORY_NO", unique=true, nullable = false)
	private Long categoryNo;

	@Column(name = "CATEGORY_NAME", nullable = false, length=100)
	private String categoryName;

}
