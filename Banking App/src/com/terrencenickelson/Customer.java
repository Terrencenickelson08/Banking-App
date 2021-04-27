package com.terrencenickelson;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private String customerName;
	private int pinNumber;
	private List<Double> transactions;
	
		public Customer(String name, int pin) {
			this.customerName = customerName;
			this.pinNumber = pinNumber;
			this.transactions = new ArrayList<>();
		}
		
		public void addTransaction(double amount) {
			this.transactions.add(amount);
		}
		
		public String getName(String name) {
			customerName = name;
		return customerName;
		}
		
		public List<Double> getTransactions() {
			return transactions;
		}

		public int getPin(int pin) {
			pinNumber = pin;
			return pinNumber;
		}
		
		public static Customer newCustomer(String name, int pin) {
			return new Customer(name, pin);
		}
		
		

}
