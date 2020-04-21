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

    // This is invoked after a bean is created for this class and all the
    // transactions from dataset are loaded and stored.
    @PostConstruct
    public void loadTransactions() {
	log.info("****** Loading transaction data from file on applciation startup ***************8");
	this.transactions = helper.loadTransactions();
	log.info("Loaded " + transactions.size() + " Transaction Records from the Dataset");
    }

    @Override
    public List<Transaction> fetchAllTransactions() throws Exception {
	return this.transactions;
    }

    // The life of a new transaction is until the server is bounced
    // Once it is bounced, all the new transactions are cleared.
    @Override
    public List<Transaction> addNewTransaction(Double price) throws Exception {
	Double rewards = helper.calculateRewards(price);
	Transaction transaction = new Transaction(transactions.size() + 1, price, rewards);
	this.transactions.add(transaction);
	helper.addToRewards(rewards);
	return transactions;
    }

}
