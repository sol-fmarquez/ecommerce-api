package com.amazon.ecommerceapi.controllers;

import com.amazon.ecommerceapi.domain.OrderLineItem;
import com.amazon.ecommerceapi.domain.Product;

import com.amazon.ecommerceapi.services.OrderLineItemService;
import com.amazon.ecommerceapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


@RestController
public class OrderLineItemController {

    @Autowired
    OrderLineItemService orderLineItemService;

    @Autowired
    ProductService productService;

    @PostMapping("ecommerce/orderlineitem/product/{productId}")
    public OrderLineItem createOrderLineItem(@PathVariable Integer productId, @RequestBody OrderLineItem orderLineItem){


        Product product = productService.findProduct(productId);
        orderLineItem.setProduct(product);
        orderLineItem.setPrice(product.getPrice());
        orderLineItem.setTotalPrice(product.getPrice().multiply(new BigDecimal(orderLineItem.getQuantity())));
        return orderLineItemService.saveOrderLineItem(orderLineItem);

    }

    @GetMapping("ecommerce/orderlineitem/{id}")
    public OrderLineItem getOrderLineItem(@PathVariable Integer id) {

        return orderLineItemService.findOrderLineItem(id);
    }

    @DeleteMapping("/ecommerce/orderlineitem/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        orderLineItemService.deleteOrderLineItem(id);
        return ResponseEntity.ok().body("Account has been deleted successfully.");
    }

    @GetMapping("ecommerce/shipments/{shipment_id}/orderlineitem/")
    public OrderLineItem getOrderLineItemsByShipmentId(@PathVariable Integer shipment_id) {
        return orderLineItemService.findOrderLineItemByShipmentId(shipment_id);
    }

}
