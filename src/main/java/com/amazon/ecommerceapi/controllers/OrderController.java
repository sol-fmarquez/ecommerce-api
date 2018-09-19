package com.amazon.ecommerceapi.controllers;

import com.amazon.ecommerceapi.domain.*;
import com.amazon.ecommerceapi.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    AccountService accountService;

    @Autowired
    AddressService addressService;

    @Autowired
    OrderLineItemService orderLineItemService;

    @Autowired
    ShipmentService shipmentService;

    @PostMapping("ecommerce/accounts/{account_id}/addresses/{address_id}/order/")
    public Order createOrder(@PathVariable Integer account_id, @PathVariable Integer address_id, @RequestBody Order order) {

        Account account = accountService.getAccount(account_id);
        Address address = addressService.findAddress(account, address_id);
        order.setAccount(account);
        order.setShippingAddress(address);

        List<Shipment> shipments = shipmentService.findShipmentsByAddress(address);
        List<OrderLineItem> lineItems = order.getLineItems();
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Shipment shipment: shipments) {
           OrderLineItem orderLineItem = orderLineItemService.findOrderLineItemByShipmentId(shipment.getId());
           lineItems.add(orderLineItem);
           totalPrice = totalPrice.add(orderLineItem.getTotalPrice());

        }

        order.setLineItems(lineItems);
        order.setTotalPrice(totalPrice);

        return orderService.saveOrder(order);

    }

    @GetMapping("ecommerce/order/{order_id}")
    public Order getOrder(@PathVariable Integer order_id) {

        return orderService.findOrder(order_id);
    }
}
