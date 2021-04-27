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
			byte option = SC.nextByte();
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

	
	 public static void intro() {
		INTRO.greeting();
	}
	
	 public static void printOptions() {
		 System.out.println("\nPlease select one of the following options: " +
				"\n 1: Check Balance" +
	            "\n 2: Make Deposit" +
	            "\n 3: Make Withdrawal" +
	            "\n 4: Transfer Funds" +
	            "\n 5: Sign Out");
	}
	
	
	 public static void createCheckingAcc(int accountChoice) {
		 chosenAcc = accountChoice;
		 System.out.println("\nPlease enter a inital deposit to activate your account: \n"
				 + "Min. Deposit: $100");
			double deposit = SC.nextDouble();
			if(deposit < 100) {
				System.out.println("\nDeposit Declined - Please enter a valid amount.");
				INTRO.createAccount();
			}else if(deposit > 1000000) {
				System.out.println("\nThe maximum amount allowed in your Checking Account is $1,000,000. \n" 
				+ "Please enter a valid amount");
				INTRO.createAccount();
			}else {
				CK.getBalance(deposit);
				creditCard();
			}	
	 }
	 
	 public static void createSavingsAcc(int accountChoice) {
		 chosenAcc = accountChoice;
		 System.out.println("\nPlease enter a inital deposit to activate your account: \n" 
				 + "Min. Deposit: $200");
			double deposit = SC.nextDouble();
			if(deposit < 200 ) {
				System.out.println("\nDeposit Declined - Please enter a valid amount.");
				INTRO.createAccount();
			}else if(deposit > 500000) {
				System.out.println("\nThe maximum amount allowed in your Savings Account is $5,000,000. \n" 
				+ "Please enter a valid amount");
				INTRO.createAccount();
			}else {
				SV.getBalance(deposit);
				creditCard();
			}
	 	}
	 
	 public static void createBusinessAcc(int accountChoice) {
		 chosenAcc = accountChoice;
		 System.out.println("\nPlease enter a inital deposit to activate your account: \n"
				 + "Min. Deposit: $1000");
			double deposit = SC.nextDouble();
			if(deposit < 1000) {
				System.out.println("\nDeposit Declined - Please enter a valid amount.");
				INTRO.createAccount();
			}else if(deposit > 10000000) {
				System.out.println("\nThe maximum amount allowed in your Business Account is $10,000,000. \n" 
				+ "Please enter a valid amount");
				INTRO.createAccount();
			}else {
				BS.getBalance(deposit);
				printOptions();
			}
	 	}
	 
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
	  
	 
	 private static void checkBalance() {
		 System.out.println("\nWhich account balance would you like to check?\n" 
	                + "1. Checking\n" 
	                + "2. Saving");
			byte choice = SC.nextByte();
		
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
	  
	 private static void deposit() {
		 System.out.println("\nWhich account would you like to deposit into?\n" 
	                + "1. Checking\n" 
	                + "2. Saving");
	        byte choice = SC.nextByte();
	       
	        if(choice == 1) {
	        	CK.amountToDeposit();
	        }else if(choice == 2) {
	        	SV.amountToDeposit();
	        }else {
				System.out.println("\nInvalid Selection - Please select a vaild option");
			}	
	 	}
	 
	private static void openedAccountWithdral() {
			if(chosenAcc == 1) {
				CK.amountToWithdrawl();
			}else if(chosenAcc == 2) {
				SV.amountToWithdrawl();
			}else if(chosenAcc == 3) {
				BS.amountToWithdrawl();
			}else {
				withdrawl();
			}
		}
	 
	 private static void withdrawl() {
		 System.out.println("\nWhich account would you like to withdrawl from?\n" 
	                + "1. Checking\n" 
	                + "2. Saving");
	        byte choice = SC.nextByte();
	       
	        if(choice == 1) {
	        	CK.amountToWithdrawl();
	        }else if(choice == 2) {
	        	SV.amountToWithdrawl();
	        }else {
				System.out.println("\nInvalid Selection - Please select a vaild option");
			}	
	 	}
	 
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
	
	private static void transfer() {
		System.out.println("\nWhich account would you like to transfer funds from? \n"
				+"1. Checking\n"
				+"2. Savings");
		byte choice = SC.nextByte();
		
		if(choice == 1) {
			CK.makeTransfer(SV);
		}else if(choice == 2 ) {
			SV.makeTransfer(CK);
		}else {
			System.out.println("\nInvalid Option - Please try again");
		}
	} 
	
	private static void creditCard() {
		if(chosenAcc == 1 || chosenAcc == 2) {
			System.out.println("\nThank you for opening a Savings Account! \n"
					+"Would you be interested in applying for a Credit Card with us? \n"
					+"1. Yes\n"
					+"2. No, not at this time.");
			
			byte choice = SC.nextByte();
			if(choice == 1) {
				CC.openCreditCard();
			}else if(choice == 2){
				System.out.println("\nNo problem, if you ever change your mind we will be here to assist.");
				printOptions();
			}else {
				System.out.println("\nInvaild Entry - Please select option one or two.");
				creditCard();
				return;
			}
		}
	}
}
