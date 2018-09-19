package com.amazon.ecommerceapi.controllers;

import com.amazon.ecommerceapi.domain.Account;
import com.amazon.ecommerceapi.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    // get all accounts from the database
    @GetMapping("ecommerce/accounts")
    public List<Account> getAllAccounts() {
        return accountService.findAll();
    }

    // get account by id
    @GetMapping("ecommerce/accounts/{id}")
    public Account getAccount(@PathVariable Integer id) {

        Account account = accountService.getAccount(id);
        return account;
    }

    // create new account
    @PostMapping("ecommerce/accounts")
    @ResponseBody
    public Account createAccount( @RequestBody Account account) {

        return accountService.save(account);
    }

    // update account; still not working
    @PutMapping("ecommerce/accounts/{id}")
    public Account updateAccount(@PathVariable Integer id, @RequestBody Account accountRequest) {

        Account account = accountService.getAccount(id);
        account.setEmail(accountRequest.getEmail());
        account.setFirstName(account.getFirstName());
        account.setLastName(account.getLastName());
        return accountService.save(account);

    }

    // delete account from the database
    @DeleteMapping("/ecommerce/accounts/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok().body("Account has been deleted successfully.");
    }
}
