package com.amazon.ecommerceapi.services;

import com.amazon.ecommerceapi.domain.Account;
import com.amazon.ecommerceapi.domain.Address;
import com.amazon.ecommerceapi.repositories.AccountRepository;
import com.amazon.ecommerceapi.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public List<Address> findAddressesbyAccountId(Integer id) {

        List<Address> addresses = addressRepository.findByAccountId(id);
        return addresses;
    }

    public Address findAddress(Account account, Integer addressId) {

        return addressRepository.findAddressByAccountAndId(account, addressId);
    }

    public Address save(Address address) {

        Address savedAddress = addressRepository.save(address);
        return savedAddress;
    }

    public void deleteAddress(Account account, Integer addressId) {

        addressRepository.deleteAddressByAccountAndId(account, addressId);
    }

}
