package com.pgs.soft.pduleba.chain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ATMService {

	private int amount;

	@Autowired
	public ATMService(@Value("${atm.amount}") int amount) {
		this.amount = amount;
	}

	public synchronized void withdraw(int requestedAmount) {
		if (contains(requestedAmount)) {
			amount -= requestedAmount;
		}
	}

	public synchronized boolean contains(int requestedAmount) {
		return amount >= requestedAmount;
	}

	public int saldo() {
		return amount;
	}
	
}
