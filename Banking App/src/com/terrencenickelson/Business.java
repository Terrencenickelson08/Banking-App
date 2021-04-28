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
		
		//method takes the initial deposit amount and adds it to the balance
		public void getBalance(double amount) {
			initDepositAmount = amount;
			this.balance = initDepositAmount;
			getNewBalance();
		}

		//prints the business account balance
		public void getNewBalance() {
			System.out.println("\nYour current Business balance is: $" + this.balance );
		}

		//takes in user input of the amount to deposit sends it to the makeDeposit method
		public void amountToDeposit() {
			   System.out.println("\nPlease enter the amount you want to deposit:");
		       double amountDeposited = SC.nextDouble();
		       makeDeposit(amountDeposited);
		}
		
		public void makeDeposit(double amount) {
			//checks to make sure the amount being deposited is a positive number and is not greater than the max allowed in the account
			 if (amount <= 0 || amount > this.maxBalance) {
				 	System.out.println("Deposit Declined - Please deposit an amount between 0 - $10,000,000");
		            return;
		        }
			 //adds the amount passes in to the account balance
		        this.balance = (this.balance + amount);
		        System.out.println("\nDeposit Accepted. \n"
		                + "Your updated BUSINESS account balance is: \n$" + this.balance);
		    }
		
		//takes in user input on the amount of fund to withdrawal 
		public void amountToWithdrawal() {
			   System.out.println("\nPlease enter the amount you want to withdrawal:");
		       double amountWithdrawal = SC.nextDouble();
		       makeWithdrawal(amountWithdrawal);
		}

		public void makeWithdrawal(double amount) {
			//checks to make sure amount passed in is greater than 0 and the account has funds to withdrawal in it
			 if(amount == 0 || this.balance == 0) {
				 	System.out.println("\nPlease make a deposit first.");
		            return;
			 }
			 //checks for over drafts
			 	if(amount > this.balance) {
		            System.out.println("\nInsufficient Funds: Over drafts are not permitted. ");	
		            return;
		     //if all checks are passed this process the withdrawal 
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
