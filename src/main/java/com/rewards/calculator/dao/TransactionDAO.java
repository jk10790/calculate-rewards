package com.rewards.calculator.dao;

import java.util.List;

import com.rewards.calculator.model.Transaction;

public interface TransactionDAO {

    public List<Transaction> fetchAllTransactions() throws Exception;

    public List<Transaction> addNewTransaction(Double price) throws Exception;

}
