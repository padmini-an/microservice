package com.eatza.orderingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eatza.orderingservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
