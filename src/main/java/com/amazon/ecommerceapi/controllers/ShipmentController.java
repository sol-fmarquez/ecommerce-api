package com.amazon.ecommerceapi.controllers;

import com.amazon.ecommerceapi.domain.Account;
import com.amazon.ecommerceapi.domain.Address;
import com.amazon.ecommerceapi.domain.OrderLineItem;
import com.amazon.ecommerceapi.domain.Shipment;
import com.amazon.ecommerceapi.services.AccountService;
import com.amazon.ecommerceapi.services.AddressService;
import com.amazon.ecommerceapi.services.OrderLineItemService;
import com.amazon.ecommerceapi.services.ShipmentService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShipmentController {

    @Autowired
    ShipmentService shipmentService;

    @Autowired
    OrderLineItemService orderLineItemService;

    @Autowired
    AddressService addressService;

    @Autowired
    AccountService accountService;

    @PostMapping("ecommerce/shipments/accounts/{account_id}/addresses/{address_id}/orderlineitems/{orderlineitem_id}")
    public Shipment createShipment(@PathVariable Integer account_id,
                                   @PathVariable Integer address_id,
                                   @PathVariable Integer orderlineitem_id, @RequestBody Shipment shipment) {

        Account account = accountService.getAccount(account_id);
        Address address = addressService.findAddress(account, address_id);
        OrderLineItem orderLineItem = orderLineItemService.findOrderLineItem(orderlineitem_id);
        shipment.setAccount(account);
        shipment.setShippingAddress(address);
        orderLineItem.setShipment(shipment);

//        List<OrderLineItem> oliList = shipment.getOrderLineItems();
//        oliList.add(orderLineItem);
        return shipmentService.saveShipment(shipment);

    }

    @GetMapping("ecommerce/shipments/{shipment_id}")
    public Shipment getShipment(@PathVariable Integer shipment_id) {

        return shipmentService.findShipment(shipment_id);
    }

}
