package com.terrencenickelson;

import java.util.List;
import java.util.Scanner;

public abstract class BankAccount extends Bank {
	
	protected abstract void getBalance(double amount);
	protected abstract void getNewBalance();
	protected abstract void amountToDeposit();
	protected abstract void makeDeposit(double amount);
	protected abstract void amountToWithdrawl();
	protected abstract void makeWithdrawl(double amount);
	protected abstract void makeTransfer(BankAccount bankAccount);
	protected abstract void processTransfer(double amount, BankAccount bankAccount);
	protected abstract void acceptTransfer(double amount);
	
}

	
	

	
