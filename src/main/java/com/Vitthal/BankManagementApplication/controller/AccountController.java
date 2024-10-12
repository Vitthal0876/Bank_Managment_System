package com.Vitthal.BankManagementApplication.controller;

import com.Vitthal.BankManagementApplication.entity.Account;
import com.Vitthal.BankManagementApplication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService service;

    //create account
    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account createAccount = service.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
    }

    @GetMapping("/{accountNumber}")
    public Account getAccountByAccountNumber(@PathVariable Long accountNumber) {
        Account account = service.getAccountDetailByAccountNumber(accountNumber);
        return account;
    }

    @GetMapping("/getallaccount")
    public List<Account> getAllAccountDetails() {
        List<Account> allAccountDetails = service.getAllAccountDetail();
        return allAccountDetails;
    }

    @PutMapping("/deposit/{accountNumber}/{amount}")
    public Account depositAccount(@PathVariable Long accountNumber, @PathVariable Double amount) {
        Account account = service.depositAmount(accountNumber, amount);
        return account;

    }

    @PutMapping("/withdrwa/{accountNumber}/{amount}")
    public Account withdrwaAccount(@PathVariable Long accountNumber, @PathVariable Double amount) {
        Account account = service.withdrwaAmount(accountNumber, amount);
        return account;
    }
    @DeleteMapping("/delete/{accountNumber}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long accountNumber){
        service.closeAccount(accountNumber);
         return ResponseEntity.status(HttpStatus.ACCEPTED).body(("Account closed successfully"));

    }
}
