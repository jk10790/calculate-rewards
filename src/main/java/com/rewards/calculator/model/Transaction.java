package com.rewards.calculator.model;

import org.springframework.stereotype.Component;

@Component
public class Transaction {

    private Integer transactionId;

    private Double price;

    private Double rewards;

    public Transaction() {
    }

    public Transaction(Integer transactionId, Double price, Double rewards) {
	super();
	this.transactionId = transactionId;
	this.price = price;
	this.rewards = rewards;
    }

    public Integer getTransactionId() {
	return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
	this.transactionId = transactionId;
    }

    public Double getPrice() {
	return price;
    }

    public void setPrice(Double price) {
	this.price = price;
    }

    public Double getRewards() {
	return rewards;
    }

    public void setRewards(Double rewards) {
	this.rewards = rewards;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((price == null) ? 0 : price.hashCode());
	result = prime * result + ((rewards == null) ? 0 : rewards.hashCode());
	result = prime * result + ((transactionId == null) ? 0 : transactionId.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Transaction other = (Transaction) obj;
	if (price == null) {
	    if (other.price != null)
		return false;
	} else if (!price.equals(other.price))
	    return false;
	if (rewards == null) {
	    if (other.rewards != null)
		return false;
	} else if (!rewards.equals(other.rewards))
	    return false;
	if (transactionId == null) {
	    if (other.transactionId != null)
		return false;
	} else if (!transactionId.equals(other.transactionId))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Transaction [transactionId=" + transactionId + ", price=" + price + ", rewards=" + rewards + "]";
    }
}
