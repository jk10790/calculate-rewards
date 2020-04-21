package com.rewards.calculator.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rewards.calculator.helper.TransactionHelper;
import com.rewards.calculator.model.Transaction;

@Repository
public class TransactionDAOImpl implements TransactionDAO {

    Logger log = LoggerFactory.getLogger(TransactionDAOImpl.class);

    @Autowired
    TransactionHelper helper;

    private List<Transaction> transactions;

    @PostConstruct
    public void loadTransactions() {
	log.info("Loading transaction data from file on applciation startup");
	this.transactions = helper.loadTransactions();
	log.info("Loaded " + transactions.size() + " Transactions");
    }

    @Override
    public List<Transaction> fetchAllTransactions() throws Exception {
	return this.transactions;
    }

    @Override
    public List<Transaction> addNewTransaction(Double price) throws Exception {
	Double rewards = helper.calculateRewards(price);
	Transaction transaction = new Transaction(transactions.size() + 1, price, rewards);
	this.transactions.add(transaction);
	helper.addToRewards(rewards);
	return transactions;
    }

}
