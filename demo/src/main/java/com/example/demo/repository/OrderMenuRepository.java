package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.example.demo.domain.Menu;
import com.example.demo.domain.OrderMenu;

public interface OrderMenuRepository extends JpaRepository<OrderMenu, Long>, QuerydslPredicateExecutor<OrderMenu> {
	
}
