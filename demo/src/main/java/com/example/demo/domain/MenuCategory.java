package com.example.demo.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "MENU_CATEGORY")
@Getter
@NoArgsConstructor( access = AccessLevel.PUBLIC )
@ToString(exclude = { "menuList" })
public class MenuCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CATEGORY_NO", unique=true, nullable = false)
	private Long categoryNo;

	@Column(name = "CATEGORY_NAME", nullable = false, length=100)
	private String categoryName;
	
	@OneToMany(mappedBy = "menuCategory")
	private List<Menu> menuList;

}
