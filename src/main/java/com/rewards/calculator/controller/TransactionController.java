package com.rewards.calculator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rewards.calculator.helper.TransactionHelper;
import com.rewards.calculator.service.TransactionService;

@Controller
public class TransactionController {

    Logger log = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    TransactionService service;
    
    @Autowired
    TransactionHelper helper;

    
    //This can be accessed by either 'localhost:8080/' or 'localhost:8080/transactions'
    @GetMapping(value = {"/", "/transactions"})
    public String getTransactionRecords(Model model) {
	try {
	    log.info("Control in method:: getTransactionRecords ");
	    model.addAttribute("transactions", service.fetchAllTransactions());
	    model.addAttribute("totalRewards", helper.getTotalRewards());
	} catch (Exception e) {
	    log.error("An Error has occured when fetching transaction records");
	    model.addAttribute("errorMsg", "An Error has occured when fetching transaction records");
	}
	return "transactions";
    }

    @PostMapping(value = "/transactions/{price}")
    public String addTransactionRecord(@PathVariable("price") Double price, Model model) {
	try {
	    log.info("Control in method:: addTransactionRecord ");
	    model.addAttribute("transactions", service.addNewTransaction(price));
	    model.addAttribute("totalRewards", helper.getTotalRewards());
	} catch (Exception e) {
	    log.error("An Error has occured when adding transaction record");
	    model.addAttribute("errorMsg", "An Error has occured when adding transaction record");
	}
	return "transactions";
    }
}
