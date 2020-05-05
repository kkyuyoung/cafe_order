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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "CUSTOMER")
@Getter
@NoArgsConstructor( access = AccessLevel.PUBLIC )
@ToString(exclude = { "orderList" })
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUSTOMER_NO", unique = true, nullable = false)
	private Long customerNo;

	@Column(name = "CUSTOMER_ID", nullable = false, length = 100)
	private String customerId;

	@Column(name = "CUSTOMER_PW", nullable = false, length = 200)
	private String customerPw;

	@Column(name = "CUSTOMER_NAME", nullable = false, length = 100)
	private String customerName;

	@Column(name = "TEL", nullable = false, length = 20)
	private String tel;

	@Column(name = "BIRTH", nullable = false, columnDefinition = "char(8)")
	private String birth;

	@Column(name = "GENDER", nullable = false, columnDefinition = "char(1)")
	private String gender;

	@OneToMany(mappedBy = "customer")
	private List<Order> orderList;

	@Builder
	public Customer(Long customerNo, String customerId, String customerPw, String customerName, String tel,
			String birth, String gender) {
		this.customerNo = customerNo;
		this.customerId = customerId;
		this.customerPw = customerPw;
		this.customerName = customerName;
		this.tel = tel;
		this.birth = birth;
		this.gender = gender;
	}

}
