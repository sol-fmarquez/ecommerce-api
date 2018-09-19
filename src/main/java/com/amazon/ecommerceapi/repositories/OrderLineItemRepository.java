package com.amazon.ecommerceapi.repositories;

import com.amazon.ecommerceapi.domain.OrderLineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderLineItemRepository extends JpaRepository<OrderLineItem, Integer> {

        OrderLineItem findByShipmentId(Integer id);
}
