package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Order;
import com.example.demo.domain.OrderMenu;
import com.example.demo.domain.QMenu;
import com.example.demo.domain.QOrder;
import com.example.demo.domain.QOrderMenu;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.MenuRepository;
import com.example.demo.repository.OrderMenuRepository;
import com.example.demo.repository.OrderRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	MenuRepository menuRepository;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderMenuRepository orderMenuRepository;

	@PersistenceContext
	private EntityManager em;

	int rank = 0;

	@Test
	void select() {
		// 메뉴 베스트 순
		JPAQueryFactory queryFactory = new JPAQueryFactory(em);

		QOrderMenu qOrderMenu = QOrderMenu.orderMenu;
		QMenu qMenu = QMenu.menu;

		// 주문개수가 가장 많은 베스트1,2,3 메뉴 출력
		List<resBestMenu> RestDtolist = queryFactory
				.select(Projections.fields(resBestMenu.class, qMenu.menuName, qOrderMenu.orderCount.sum().as("sumCnt"),
						qOrderMenu.orderPrice.sum().as("sumPrice")))
				.from(qOrderMenu).leftJoin(qOrderMenu.menu, qMenu).groupBy(qMenu.menuNo)
				.orderBy(qOrderMenu.orderCount.sum().desc()).limit(3).fetch();

		RestDtolist.forEach(a -> {
			rank++;
			System.out.println(
					rank + "위 : " + a.getMenuName() + ", 총 주문 개수 : " + a.getSumCnt() + "개, 판매 합 : " + a.getSumPrice());
		});

//		SELECT sum(om.order_count) orderCnt, sum(om.order_price), m.menu_name 
//		FROM order_menu om left join menu m on om.menu_no = m.menu_no
//		group by m.menu_no 
//		order by orderCnt desc limit 3;

	}

	void insertOrder() {

		orderRepository.save(Order.builder().allOrderCount(4).allOrderPrice(6500).customerNo(5L)
				.orderDate(LocalDateTime.now()).build());

		orderMenuRepository.save(OrderMenu.builder().menuNo(5L).orderCount(1).orderNo(3L).orderPrice(2000).build());

		orderMenuRepository.save(OrderMenu.builder().menuNo(7L).orderCount(1).orderNo(3L).orderPrice(1500).build());

		orderMenuRepository.save(OrderMenu.builder().menuNo(9L).orderCount(2).orderNo(3L).orderPrice(3000).build());

	}

	void insertCustomer() {
		customerRepository.save(Customer.builder().customerId("rladnwn").customerPw("xiness").customerName("김우주")
				.tel("010-3735-3096").birth("830502").gender("M").build());

		customerRepository.save(Customer.builder().customerId("ghdrlfehd").customerPw("xiness").customerName("홍길동")
				.tel("010-1234-5678").birth("960212").gender("M").build());

		customerRepository.save(Customer.builder().customerId("rkdrkacks").customerPw("xiness").customerName("강감찬")
				.tel("010-5424-4323").birth("801205").gender("M").build());

		customerRepository.save(Customer.builder().customerId("rlatkfkd").customerPw("xiness").customerName("김사랑")
				.tel("010-2345-5243").birth("901205").gender("W").build());
	}
}
