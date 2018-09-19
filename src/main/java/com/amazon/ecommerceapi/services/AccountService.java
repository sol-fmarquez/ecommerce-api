package com.amazon.ecommerceapi.services;

import com.amazon.ecommerceapi.domain.Account;
import com.amazon.ecommerceapi.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account getAccount(Integer accountId) {

        Optional<Account> accountRetrieved = accountRepository.findById(accountId);
        Account account = accountRetrieved.get();
        return account;
    }

    public Account save(Account account) {

        Account savedAccount = accountRepository.save(account);
        return savedAccount;
    }

    public void deleteAccount(Integer accountId) {

        accountRepository.deleteById(accountId);
    }

}
