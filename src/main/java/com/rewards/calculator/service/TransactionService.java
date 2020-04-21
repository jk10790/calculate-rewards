package com.rewards.calculator.service;

import java.util.List;

import com.rewards.calculator.model.Transaction;

public interface TransactionService {

    public List<Transaction> fetchAllTransactions() throws Exception;

    public List<Transaction> addNewTransaction(Double price) throws Exception;
}
