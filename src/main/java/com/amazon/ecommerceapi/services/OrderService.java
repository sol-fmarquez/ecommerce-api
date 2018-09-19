package com.amazon.ecommerceapi.services;

import com.amazon.ecommerceapi.domain.Order;
import com.amazon.ecommerceapi.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order findOrder(Integer orderNumber) {

        Optional<Order> retrievedOrder = orderRepository.findById(orderNumber);
        return retrievedOrder.get();
    }
}
