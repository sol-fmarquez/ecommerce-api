package com.amazon.ecommerceapi.services;

import com.amazon.ecommerceapi.domain.Address;
import com.amazon.ecommerceapi.domain.Shipment;
import com.amazon.ecommerceapi.repositories.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipmentService {

    @Autowired
    ShipmentRepository shipmentRepository;

    public Shipment saveShipment(Shipment shipment) {

        return shipmentRepository.save(shipment);
    }

    public Shipment findShipment(Integer id) {

        Optional<Shipment> shipmentRetrieved = shipmentRepository.findById(id);
        return shipmentRetrieved.get();
    }

    public List<Shipment> findShipmentsByAddress(Address address) {

        return shipmentRepository.findShipmentsByShippingAddress(address);
    }

    public void deleteShipment(Integer id) {

        shipmentRepository.deleteById(id);
    }
}
