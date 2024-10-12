package com.Vitthal.BankManagementApplication.service;

import com.Vitthal.BankManagementApplication.entity.Account;
import com.Vitthal.BankManagementApplication.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository repo;
    @Override
    public Account createAccount(Account account) {
       Account account_saved= repo.save(account);
        return account_saved;
    }

    @Override
    public Account getAccountDetailByAccountNumber(Long accountNumber) {
        Optional<Account> account=repo.findById(accountNumber);
        if (account.isEmpty()){
            throw new RuntimeException("Account not found");
        }
         Account account_found=account.get();
        return account_found;
    }

    @Override
    public List<Account> getAllAccountDetail() {
       List<Account> listOfAccount= repo.findAll();
        return listOfAccount;
    }

    @Override
    public Account depositAmount(Long accountNumber, Double amount) {
       Optional<Account> account= repo.findById(accountNumber);
       if (account.isEmpty()){
           throw new RuntimeException("Account  not presnt");
       }
       Account  accountPresent=account.get();
        double totalBalnce= accountPresent.getAccount_balance()+amount;
        accountPresent.setAccount_balance(totalBalnce);
        repo.save(accountPresent);
        return accountPresent;
    }

    @Override
    public Account withdrwaAmount(Long accountNumber, Double amount) {
        Optional<Account> account= repo.findById(accountNumber);
        if (account.isEmpty()){
            throw new RuntimeException("Account  not presnt");
        }
        Account  accountPresent=account.get();
         double accountBalance=accountPresent.getAccount_balance()-amount;
         accountPresent.setAccount_balance(accountBalance);
        repo.save(accountPresent);
        return accountPresent;
    }

    @Override
    public void closeAccount(Long accountNumber) {
        getAccountDetailByAccountNumber(accountNumber);
        repo.deleteById(accountNumber);

    }
}
