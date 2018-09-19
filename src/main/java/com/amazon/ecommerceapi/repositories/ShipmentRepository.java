package com.amazon.ecommerceapi.repositories;

import com.amazon.ecommerceapi.domain.Address;
import com.amazon.ecommerceapi.domain.OrderLineItem;
import com.amazon.ecommerceapi.domain.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {

    List<Shipment> findShipmentsByShippingAddress(Address address);
}
