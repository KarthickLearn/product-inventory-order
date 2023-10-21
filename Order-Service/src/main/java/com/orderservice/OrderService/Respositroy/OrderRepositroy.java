package com.orderservice.OrderService.Respositroy;

import com.orderservice.OrderService.Module.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositroy extends JpaRepository<Order, Long > {
}
