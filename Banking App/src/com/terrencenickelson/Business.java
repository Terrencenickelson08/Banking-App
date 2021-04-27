package com.terrencenickelson;

import java.util.Scanner;
	

public class Business extends BankAccount {
	
		private static final Scanner SC = new Scanner(System.in);
		private double balance;
		private double maxBalance;
		private double initDepositAmount;
		
		public Business() {
			super();
			this.balance = balance;
			this.maxBalance = 10000000;
			this.initDepositAmount = initDepositAmount;
		}
	
		public void getBalance(double amount) {
			initDepositAmount = amount;
			this.balance = initDepositAmount;
			getNewBalance();
		}

		public void getNewBalance() {
			System.out.println("\nYour current Business balance is: $" + this.balance );
		}

		public void amountToDeposit() {
			 System.out.println("\nPlease enter the amount you want to deposit:");
		       double amountDeposited = SC.nextDouble();
		       makeDeposit(amountDeposited);
		}
		
		public void makeDeposit(double amount) {
			 if (amount <= 0 || amount > this.maxBalance) {
				 	System.out.println("Deposit Declined - Please deposit an amount between 0 - $10,000,000");
		            return;
		        }
		        this.balance = (this.balance + amount);
		        System.out.println("\nDeposit Accepted. \n"
		                + "Your updated BUSINESS account balance is: \n$" + this.balance);
		    }

		public void amountToWithdrawl() {
			System.out.println("\nPlease enter the amount you want to withdrawl:");
		       double amountWithdrawl = SC.nextDouble();
		       makeWithdrawl(amountWithdrawl);
		}
				
		public void makeWithdrawl(double amount) {
			 if(amount == 0 || this.balance == 0) {
				 	System.out.println("\nPlease make a deposit first.");
		            return;
			 }
			 	if(amount > this.balance) {
		            System.out.println("\nInsufficient Funds: Over drafts are not permitted. ");	
		            return;
			 	}else if(amount <= this.balance) {
			 		this.balance = (this.balance - amount);
			 		System.out.println("\nWithdrawal Accepted. \n"
		                + "Your updated SAVINGS account balance is: \n$" + this.balance);
		     	}
			}


		public void acceptTransfer(double amount) {
		}

		public void makeTransfer(BankAccount bankAccount) {
		}

		public void processTransfer(double amount, BankAccount bankAccount) {
		}

}
