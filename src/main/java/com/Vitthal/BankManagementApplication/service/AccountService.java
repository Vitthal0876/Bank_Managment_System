package com.Vitthal.BankManagementApplication.service;

import com.Vitthal.BankManagementApplication.entity.Account;

import java.util.List;

public interface AccountService {
    public Account createAccount(Account account);
    public Account getAccountDetailByAccountNumber(Long accountNumber);
    public List<Account> getAllAccountDetail();
    public  Account depositAmount(Long accountNumber,Double amount);
    public Account withdrwaAmount(Long accountNumber,Double amount);
    public void closeAccount(Long accountNumber);
}
