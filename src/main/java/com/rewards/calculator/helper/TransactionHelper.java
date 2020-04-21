package com.rewards.calculator.helper;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.rewards.calculator.model.Transaction;

@Component
public class TransactionHelper implements AutoCloseable {

    Logger log = LoggerFactory.getLogger(TransactionHelper.class);

    @Value("classpath:Transaction_Dataset.txt")
    private Resource resource;

    private Double totalRewards = 0.0;

    // This method reads the 'Transaction_Dataset.txt' file from the classpath and
    // parses through each line
    // And maps the input stream of each line to a Transaction object
    public List<Transaction> loadTransactions() {
	try (Stream<String> lines = Files.lines(Paths.get(resource.getURI()))) {

	    return lines.filter(l -> l.startsWith("Transaction id:")).map(line -> {
		Integer transactionId = Integer
			.parseInt(StringUtils.substringBetween(line, "Transaction id:", "Price:").trim());
		
		Double price = Double
			.parseDouble(StringUtils.substringBetween(line, "Price: $", "Reward points:").trim());
		
		Double rewards = Double.parseDouble(StringUtils.substringAfter(line, "Reward points:").trim());
		
		Transaction transaction = new Transaction(transactionId, price, rewards);
		//Calculate total rewards for all the transactions
		addToRewards(rewards);
		
		return transaction;
	    }).collect(Collectors.toList());

	} catch (Exception io) {
	    io.printStackTrace();
	}
	return null;
    }

    // A retailer offers a rewards program to its customers, awarding points based
    // on each recorded purchase.
    // A customer receives 2 points for every dollar spent over $100 in each
    // transaction,
    // plus 1 point for every dollar spent over $50 in each transaction
    // (e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).
    // Given a record of every transaction during a three month period,
    // calculate the reward points earned for each customer per month and total.

    public Double calculateRewards(Double price) {
	if (price >= 50 && price < 100) {
	    // a Point for each dollar over 50 until 100
	    return price - 50;
	} else if (price > 100) {
	    // Every dollar spent over 100 gets 2 points => (price -50)
	    // a Point for each dollar over 50 until 100
	    return (2 * (price - 100) + 50);
	}
	return 0.0;
    }

    public void addToRewards(Double rewards) {
	this.totalRewards = totalRewards + rewards;
    }

    public Double getTotalRewards() {
	return totalRewards;
    }

    public void setTotalRewards(Double totalRewards) {
	this.totalRewards = totalRewards;
    }

    @Override
    public void close() throws Exception {
	log.info("Closing open resources");
    }

}
