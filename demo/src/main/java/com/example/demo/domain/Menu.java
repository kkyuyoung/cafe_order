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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "MENU")
@Getter
@NoArgsConstructor( access = AccessLevel.PUBLIC ) // 테스트를 위해 임시로 Public, 의도한 코드는 PROTECTED 프록시 생성을 위해 기본 생성자가 필요함 생략될 경우 repository.find했을 경우 오류
@ToString(exclude = { "menuCategory", "orderMenuList" })
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MENU_NO", unique = true, nullable = false)
	private Long menuNo;

	@Column(name = "CATEGORY_NO")
	private Long categoryNo;

	@Column(name = "MENU_PRICE", nullable = false)
	private Integer menuPrice;

	@Column(name = "MENU_NAME", nullable = false, length = 100)
	private String menuName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CATEGORY_NO", insertable = false, updatable = false)
	private MenuCategory menuCategory;

	@OneToMany(mappedBy = "menu")
	private List<OrderMenu> orderMenuList;

	@Builder
	public Menu(Long menuNo, Long categoryNo, Integer menuPrice, String menuName) {
		this.menuNo = menuNo;
		this.categoryNo = categoryNo;
		this.menuPrice = menuPrice;
		this.menuName = menuName;
	}

}
