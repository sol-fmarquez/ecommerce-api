package com.amazon.ecommerceapi.controllers;

import com.amazon.ecommerceapi.domain.Account;
import com.amazon.ecommerceapi.domain.Address;
import com.amazon.ecommerceapi.services.AccountService;
import com.amazon.ecommerceapi.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private AccountService accountService;

    // get all addresses associated with an account
    @GetMapping("ecommerce/accounts/{id}/addresses/")
    public List<Address> getAllAddressesByAccountId(@PathVariable Integer id) {

        return addressService.findAddressesbyAccountId(id);
    }

    // create new address to an account
    @PostMapping("ecommerce/accounts/{id}/addresses")
    public Address createAddress( @PathVariable Integer id, @RequestBody Address address) {

        Account account = accountService.getAccount(id);
        address.setAccount(account);
        return addressService.save(address);

    }

    @DeleteMapping("/ecommerce/accounts/{accountId}/addresses/{addressId}")
    public ResponseEntity<?> deleteAddress(@PathVariable(value = "accountId") Integer accountId,
                                           @PathVariable(value = "addressId") Integer addressId) {

        Account account = accountService.getAccount(accountId);
        addressService.deleteAddress(account, addressId);
        return ResponseEntity.ok().body("Address has been deleted successfully.");
    }

}
