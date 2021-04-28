package com.terrencenickelson;

import java.util.Scanner;

public class Main {
	
	 private static final Scanner SC = new Scanner(System.in);
	 private static final Bank BANK = new Bank();
	 private static final Intro INTRO = new Intro();
	 private static final BankAccount CK = new Checking();
	 private static final BankAccount SV = new Savings();
	 private static final ICreditCard CC = new Savings();
	 private static final BankAccount BS = new Business();
	 private static int chosenAcc;
	 
	 public Main() {
		super();
		this.chosenAcc = chosenAcc;
	}


	public void startApp() {
		intro();
		
		boolean flag = false;
		while(!flag) {
			int option = SC.nextInt();
			SC.nextLine();
			
			switch(option) {
				case 1: 
					openedAccountBalance();
					printOptions();
					break;
				case 2:
					openedAccountDeposit();
					printOptions();
					break;
				case 3:
					openedAccountWithdral();
					printOptions();
					break;
				case 4:
					openedAccountTransfer();
					printOptions();
					break;
				case 5:
					System.out.println("\nSigning out... \n" 
					+ "Thank you for choosing " + BANK.getName());
					flag = true;
					break;
				default: 
					System.out.println("\nSorry, that was an invaild selection");
					printOptions();
					break;
				}
			}
		}

	//method calls on the greeting method in the intro class to start opening prompt
	 private static void intro() {
		INTRO.greeting();
	}
	
	 //main list of options 
	 public static void printOptions() {
		 System.out.println("\nPlease select one of the following options: " +
				"\n 1: Check Balance" +
	            "\n 2: Make Deposit" +
	            "\n 3: Make Withdrawal" +
	            "\n 4: Transfer Funds" +
	            "\n 5: Sign Out");
	}
	
	 //this method creates the checking account and passes in the account number (1) and stores it in chosenAcc
	 public static void createCheckingAcc(int accountChoice) {
		 chosenAcc = accountChoice;
		 //makes sure the initial deposit is over $100
		 System.out.println("\nPlease enter a inital deposit to activate your account: \n"
				 + "Min. Deposit: $100");
			double deposit = SC.nextDouble();
			if(deposit < 100) {
				System.out.println("\nDeposit Declined - Please enter a valid amount.");
				INTRO.createAccount();
			//makes sure the deposit isn't greater than $1000000
			}else if(deposit > 1000000) {
				System.out.println("\nThe maximum amount allowed in your Checking Account is $1,000,000. \n" 
				+ "Please enter a valid amount");
				INTRO.createAccount();
			//passes all checks then calls the check balance method. Finally, once that completes it calls the credit card prompt.
			}else {
				CK.getBalance(deposit);
				creditCard();
			}	
	 }
	 
	 //this method creates the savings account and passes in the account number (2) and stores it in chosenAcc
	 public static void createSavingsAcc(int accountChoice) {
		 chosenAcc = accountChoice;
		//makes sure the initial deposit is over $200
		 System.out.println("\nPlease enter a inital deposit to activate your account: \n" 
				 + "Min. Deposit: $200");
			double deposit = SC.nextDouble();
			if(deposit < 200 ) {
				System.out.println("\nDeposit Declined - Please enter a valid amount.");
				INTRO.createAccount();
				//makes sure the deposit isn't greater than $5000000
			}else if(deposit > 500000) {
				System.out.println("\nThe maximum amount allowed in your Savings Account is $5,000,000. \n" 
				+ "Please enter a valid amount");
				INTRO.createAccount();
			}else {
				//passes all checks then calls the check balance method. Finally, once that completes it calls the credit card prompt.
				SV.getBalance(deposit);
				creditCard();
			}
	 	}
	 
	 //this method creates the business account and passes in the account number (2) and stores it in chosenAcc
	 public static void createBusinessAcc(int accountChoice) {
		 chosenAcc = accountChoice;
		//makes sure the initial deposit is over $1000
		 System.out.println("\nPlease enter a inital deposit to activate your account: \n"
				 + "Min. Deposit: $1000");
			double deposit = SC.nextDouble();
			if(deposit < 1000) {
				System.out.println("\nDeposit Declined - Please enter a valid amount.");
				INTRO.createAccount();
			//makes sure the deposit isn't greater than $10000000
			}else if(deposit > 10000000) {
				System.out.println("\nThe maximum amount allowed in your Business Account is $10,000,000. \n" 
				+ "Please enter a valid amount");
				INTRO.createAccount();
			}else {
				//passes all checks then calls the check balance method. Finally, once that completes it calls the credit card prompt.
				BS.getBalance(deposit);
				printOptions();
			}
	 	}
	 
	//this method checks the local variable chosenAcc and depending on the number passed in it calls the related getNewBalance method
	private static void openedAccountBalance() {
			if(chosenAcc == 1) {
				CK.getNewBalance();
			}else if(chosenAcc == 2) {
				SV.getNewBalance();
			}else if(chosenAcc == 3) {
				BS.getNewBalance();
			}else {
				checkBalance();
			}
		}
	  
	 //checks which account balance to check
	 private static void checkBalance() {
		 System.out.println("\nWhich account balance would you like to check?\n" 
	                + "1. Checking\n" 
	                + "2. Saving");
		 
			int choice = SC.nextInt();
			if(choice == 1) {
				CK.getNewBalance();
			}else if(choice == 2) {
				SV.getNewBalance();
			}else if(choice == 3) {
				BS.getNewBalance();
			}else {
				System.out.println("\nInvalid Selection - Please select a vaild option");
			}			
		}
	 
	//this method checks the local variable chosenAcc and depending on the number passed in it calls the related amountToDeposit method
	private static void openedAccountDeposit() {
			if(chosenAcc == 1) {
				CK.amountToDeposit();
			}else if(chosenAcc == 2) {
				SV.amountToDeposit();
			}else if(chosenAcc == 3) {
				BS.amountToDeposit();
			}else {
				deposit();
			}
		}
	//checks which account to make a deposit into
	 private static void deposit() {
		 System.out.println("\nWhich account would you like to deposit into?\n" 
	                + "1. Checking\n" 
	                + "2. Saving");
		 
	        int choice = SC.nextInt();
	        if(choice == 1) {
	        	CK.amountToDeposit();
	        }else if(choice == 2) {
	        	SV.amountToDeposit();
	        }else {
				System.out.println("\nInvalid Selection - Please select a vaild option");
			}	
	 	}
	//this method checks the local variable chosenAcc and depending on the number passed in it calls the related amountToWithdrawl method
	private static void openedAccountWithdral() {
			if(chosenAcc == 1) {
				CK.amountToWithdrawal();
			}else if(chosenAcc == 2) {
				SV.amountToWithdrawal();
			}else if(chosenAcc == 3) {
				BS.amountToWithdrawal();
			}else {
				withdrawal();
			}
		}
	 
	//checks which account to withdrawal funds from
	 private static void withdrawal() {
		 System.out.println("\nWhich account would you like to withdrawal from?\n" 
	                + "1. Checking\n" 
	                + "2. Saving");
		 
	        int choice = SC.nextInt();
	        if(choice == 1) {
	        	CK.amountToWithdrawal();
	        }else if(choice == 2) {
	        	SV.amountToWithdrawal();
	        }else {
				System.out.println("\nInvalid Selection - Please select a vaild option");
			}	
	 	}
	 
	//this method checks the local variable chosenAcc and depending on the number passed in it prints out the related message
	private static void openedAccountTransfer() {
			if(chosenAcc == 1) {
				System.out.println("\nTransfer Declined - You only opened a Checking Account.");
			}else if(chosenAcc == 2) {
				System.out.println("\nTransfer Declined - You only opened a Savings Account.");
			}else if(chosenAcc == 3) {
				System.out.println("\nTransfer Declined - You only opened a Business Account.");
			}else {
				transfer();
			}
		}
	
	//chooses which account to transfer funds from
	private static void transfer() {
		System.out.println("\nWhich account would you like to transfer funds from? \n"
				+"1. Checking\n"
				+"2. Savings");
		
		int choice = SC.nextInt();
		if(choice == 1) {
			CK.makeTransfer(SV);
		}else if(choice == 2 ) {
			SV.makeTransfer(CK);
		}else {
			System.out.println("\nInvalid Option - Please try again");
		}
	} 
	
	//method checks the local variable chosenAcc to know where to call on the credit card prompt
	private static void creditCard() {
		if(chosenAcc == 1 || chosenAcc == 2) {
			System.out.println("\nThank you for opening a Savings Account! \n"
					+"Would you be interested in applying for a Credit Card with us? \n"
					+"1. Yes\n"
					+"2. No, not at this time.");
			
			int choice = SC.nextInt();
			if(choice == 1) {
				//the user accepted to apply for a CC and calls the interface openCreditCard. 
				CC.openCreditCard();
			}else if(choice == 2){
				//the user decided not to apply for a CC
				System.out.println("\nNo problem, if you ever change your mind we will be here to assist.");
				printOptions();
				//handles invalid entries
			}else {
				System.out.println("\nInvaild Entry - Please select option one or two.");
				creditCard();
				return;
			}
		}
	}
}
