package com.Vitthal.BankManagementApplication.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long account_number;
    @Column
    private String account_holder_name;
    public Account(){

    }

    public Account(double account_balance, String account_holder_name) {
        super();
        this.account_balance = account_balance;
        this.account_holder_name = account_holder_name;

    }

    public double getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(double account_balance) {
        this.account_balance = account_balance;
    }

    public String getAccount_holder_name() {
        return account_holder_name;
    }

    public void setAccount_holder_name(String account_holder_name) {
        this.account_holder_name = account_holder_name;
    }

    public long getAccount_number() {
        return account_number;
    }

    public void setAccount_number(long account_number) {
        this.account_number = account_number;
    }

    @Column
    private double account_balance;

    @Override
    public String toString() {
        return "Account{" +
                "account_balance=" + account_balance +
                ", account_number=" + account_number +
                ", account_holder_name='" + account_holder_name + '\'' +
                '}';
    }
}
