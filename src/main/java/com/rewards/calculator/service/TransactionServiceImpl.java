package com.rewards.calculator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rewards.calculator.dao.TransactionDAO;
import com.rewards.calculator.model.Transaction;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionDAO repository;

    @Override
    public List<Transaction> fetchAllTransactions() throws Exception {
	return repository.fetchAllTransactions();
    }

    @Override
    public List<Transaction> addNewTransaction(Double price) throws Exception {
	return repository.addNewTransaction(price);
    }

}
