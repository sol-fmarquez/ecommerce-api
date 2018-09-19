package com.amazon.ecommerceapi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "shipments")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "shipment_account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "shipment_address_id")
    private Address shippingAddress;

    @OneToMany(mappedBy ="shipment", fetch = FetchType.LAZY)
    private List<OrderLineItem> orderLineItems = new ArrayList<>();

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "mm-DD-yyyy")
    @Column(name = "shipped_date")
    private Date shippedDate;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "mm-DD-yyyy")
    @Column(name = "delivery_date")
    private Date deliveryDate;

    public Shipment(Date shippedDate, Date deliveryDate) {
//        this.account = account;
//        this.shippingAddress = shippingAddress;
//        this.orderLineItems = orderLineItems;
        this.shippedDate = shippedDate;
        this.deliveryDate = deliveryDate;
    }

    public Shipment() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public List<OrderLineItem> getOrderLineItems() {
        return orderLineItems;
    }

    public void setOrderLineItems(List<OrderLineItem> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
