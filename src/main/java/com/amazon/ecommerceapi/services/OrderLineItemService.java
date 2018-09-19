package com.amazon.ecommerceapi.services;

import com.amazon.ecommerceapi.domain.OrderLineItem;
import com.amazon.ecommerceapi.repositories.OrderLineItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderLineItemService {

    @Autowired
    OrderLineItemRepository orderLineItemRepository;

    public OrderLineItem saveOrderLineItem(OrderLineItem orderLineItem) {

        return orderLineItemRepository.save(orderLineItem);
    }

    public OrderLineItem findOrderLineItem(Integer orderLineItemId) {

        Optional<OrderLineItem> lineItem = orderLineItemRepository.findById(orderLineItemId);
        return lineItem.get();
    }

    public OrderLineItem findOrderLineItemByShipmentId(Integer shipmentId) {

        OrderLineItem lineItem = orderLineItemRepository.findByShipmentId(shipmentId);
        return lineItem;
    }

    public void deleteOrderLineItem(Integer orderLineItemId) {

        orderLineItemRepository.deleteById(orderLineItemId);
    }
}
