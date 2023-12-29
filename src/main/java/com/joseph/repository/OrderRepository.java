package com.joseph.repository;

import com.joseph.entity.Order;
import org.h2.engine.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("orderRepository")
public interface OrderRepository extends JpaRepository<Order,Long> {
}
