package com.terrencenickelson;

import java.util.Scanner;

public class Savings extends BankAccount implements ICreditCard {
	
	private static final Main MAIN = new Main();
	private static final Scanner SC = new Scanner(System.in);
	private double balance;
	private double maxBalance;
	private double initDepositAmount;
	private double maxTransferLimit;
	private double transferBalance;
	private double tranferedAmount;
	private long phoneNumber;
	
	public Savings() {
		super();
		this.balance = balance;
		this.maxBalance = 5000000;
		this.initDepositAmount = initDepositAmount;
		this.maxTransferLimit = 4000;
		this.transferBalance = transferBalance;
		this.tranferedAmount  = tranferedAmount;
		this.phoneNumber = phoneNumber;
	}
	
	public double getMaxTransferLimit() {
		return maxTransferLimit;
	}

	public double getTransferBalance() {
		return transferBalance;
	}
	
	public void acceptTransfer(double amount) {
		System.out.println(amount);
		 this.balance += amount;
	}
	
	public void getBalance(double amount) {
		initDepositAmount = amount;
		this.balance = initDepositAmount;
		getNewBalance();
	}

	public void getNewBalance() {
		System.out.println("\nYour current Savings balance is: $" + this.balance );
	}


	public void amountToDeposit() {
		 System.out.println("\nPlease enter the amount you want to deposit:");
	       double amountDeposited = SC.nextDouble();
	       makeDeposit(amountDeposited);
	}
	
	public void makeDeposit(double amount) {
		 if (amount <= 0 || amount > this.maxBalance) {
			 System.out.println("Deposit Declined - Please deposit an amount between 0 - $5,000,000" );
	            return;
	        }
	        this.balance = (this.balance + amount);
	        System.out.println("\nDeposit Accepted. \n"
	                + "Your updated SAVINGS account balance is: \n$" + this.balance);
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
	
	public void makeTransfer(BankAccount account){
		System.out.println("\nEnter amount you want to transfer into your Checking Account:");
		double amountTransferred = SC.nextDouble();
		processTransfer(amountTransferred, account);
	}

	public void processTransfer(double amount, BankAccount toAccount) {
		 double currentTransferBalance = amount + this.transferBalance;
       //Makes sure that amount entered to transfer is greater than 0 and the account has sufficient fund to transfer
       if (amount <= 0) {
           System.out.println("\nPlease enter a vaild amount: \n");
           return;
       }
       //If the first two checks clear then we calculate and process the transfer
       if (amount > this.balance) {
           System.out.println("\nInsufficient Funds: Over drafts are not permitted. Please enter a different amount: ");
           return;
       }else if(amount > this.maxTransferLimit) {
    	   System.out.println("\nThe max daily transfer limit is $4,000."); 
    	   return;
       }else if(currentTransferBalance <= this.maxTransferLimit ) {
    	   System.out.println(amount);
    	   toAccount.acceptTransfer(amount);
           this.balance -= amount;
           System.out.println("You successfully transferred " + amount + " to your Checking Account!\n" +
                   "Your updated balance is: " + this.balance);
           this.transferBalance = currentTransferBalance;
       }
	}

	public void creditScore() {
		System.out.println("Please select the range that your credit score is in: \n" 
				+"1. 300 - 579\n"
				+"2. 580 - 739\n"
				+"3. 740 - 850");
		
		byte creditRange = SC.nextByte();
		if(creditRange == 1) {
			System.out.println("\nSorry, you do not qualify at this time.");
		}else if(creditRange == 2) {
			System.out.println("\nCongrats! You qualify for our Cash Back Rewards Credit Card! \n" 
					+"\nTo complete the application we will get you on the phone with one of our reps to get you all set up. "
					+"\nPlease enter a good number to contact you: (no dashes) \n");
					long number = SC.nextLong();
					this.phoneNumber = number;
					
		}else if(creditRange == 3) {
			System.out.println("\nCongrats! You qualify for our highest-rated credit card, The Elite Rewards Card! \n"
					+"\nTo complete the application we will get you on the phone with one of our reps to get you all set up."
					+"\nPlease enter a good number to contact you: (no dashes) ");
				    long number = SC.nextLong();
				    this.phoneNumber = number;
				}
			}
	
	public void openCreditCard() {
		creditScore();
		System.out.println("\nThanks, we will contact you at " + this.phoneNumber + " shortly.");	
		MAIN.printOptions();
	}
}
