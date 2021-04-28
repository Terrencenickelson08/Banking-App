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
	
	//method takes the initial deposit amount and adds it to the balance
	public void getBalance(double amount) {
		initDepositAmount = amount;
		this.balance = initDepositAmount;
		getNewBalance();
	}

	//prints the savings account balance
	public void getNewBalance() {
		System.out.println("\nYour current Savings balance is: $" + this.balance );
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
			 System.out.println("Deposit Declined - Please deposit an amount between 0 - $5,000,000" );
	            return;
	        }
		//adds the amount passes in to the account balance
	        this.balance = (this.balance + amount);
	        System.out.println("\nDeposit Accepted. \n"
	                + "Your updated SAVINGS account balance is: \n$" + this.balance);
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
	
	//method takes in the account that receives the transfer and the amount and passes them both to the processTransfer method
	public void makeTransfer(BankAccount toAccount){
		System.out.println("\nEnter amount you want to transfer into your Checking Account:");
		double amountTransferred = SC.nextDouble();
		processTransfer(amountTransferred, toAccount);
	}
	
	//sends the transfer amount to the checking account to be added to its total
	public void acceptTransfer(double amount) {
		System.out.println(amount);
		 this.balance += amount;
	}

	//
	public void processTransfer(double amount, BankAccount toAccount) {
		 double currentTransferBalance = amount + this.transferBalance;
       //Makes sure that  transfer amount entered to transfer is greater than $0 
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
    	//checks to make sure that the current transfer balance doesn't exceed the max transfer limit 
       }else if(currentTransferBalance <= this.maxTransferLimit ) {
    	//sends the transfer amount to the checking account to be added its balance
    	   toAccount.acceptTransfer(amount);
    	//deducts the transfer amount from the savings balance then prints off the updated balance
           this.balance -= amount;
           System.out.println("You successfully transferred " + amount + " to your Checking Account!\n" +
                   "Your updated balance is: " + this.balance);
           this.transferBalance = currentTransferBalance;
       }
	}
	
	//method checks and processes the options based on user credit score
	public void creditScore() {
		System.out.println("Please select the range that your credit score is in: \n" 
				+"1. 300 - 579\n"
				+"2. 580 - 739\n"
				+"3. 740 - 850");
		
		int creditRange = SC.nextInt();
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
	
	//processes the credit score method
	public void openCreditCard() {
		creditScore();
		System.out.println("\nThanks, we will contact you at " + this.phoneNumber + " shortly.");	
		MAIN.printOptions();
	}
}
