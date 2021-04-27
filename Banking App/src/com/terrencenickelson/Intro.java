package com.terrencenickelson;

import java.util.*;

public class Intro{
	
	private static final Scanner SC = new Scanner(System.in);
	private static final Main MAIN = new Main();
	private static final Bank BANK = new Bank();

	public void greeting() {
		System.out.println("\nWelcome to " + BANK.getName() + "!\n" 
				+ "\nHow may we assist you today?\n" 
				+ "1. Access my Account\n"
				+ "2. Create an Account\n"
				+ "3. Help\n"
				+ "4. Sign Out");
		
		
			byte selection = SC.nextByte();
			SC.nextLine();
			
			switch(selection) {
				case 1:
					accessAccount();
					break;
				case 2:
					createAccount();
					break;
				case 3:
					System.out.println("\nPlease contact Customer Support at 555-555-5555 for further assistance. \n" 
					+ "Thank you for choosing " + BANK.getName() + "!");
					break;
				case 4:
					System.out.println("\nSigning out...\n"
					+ "Thanks for choosing " + BANK.getName() + "! Have a blessed day.");
					break;
				default: 
					System.out.println("\nSorry, that was an invaild selection");
					greeting();
					return;
				
				}
			}
	
	public void accessAccount() {
		String nameOnAcc, pin;
        //Requires user to input name on account and throws a NullPointerException if they don't
		try {
            System.out.println("\nPlease enter name on account:");
            nameOnAcc = SC.nextLine();
            if (nameOnAcc.isEmpty()) {
                throw new NullPointerException("Name Required!");
            }
            //Requires user to input a PIN Number and throws a NullPointerException if they don't
            System.out.println("\nWelcome back, " + nameOnAcc + "!\nPlease enter your PIN Number:");
            pin = SC.nextLine();
            if (pin.isEmpty()) {
                throw new NullPointerException("PIN Number Required");
            }
            System.out.println("\nPIN Accepted. Thank you!");
            MAIN.printOptions();
        }
        //Returns the error message depending on what NullPointerException was caught
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
            greeting();
            return;
        }
	}
	
	public void createAccount() {
		System.out.println("\nSelect the type of account you would like to create: "
				+ "\n1. Checking Account"
				+ "\n2. Savings Account"
				+ "\n3. Business Account");
		
		int choice = SC.nextInt();
		switch(choice) {
		case 1: 
			Checking ck = new Checking();
			MAIN.createCheckingAcc(choice);
			break;
		case 2:
			Savings sv = new Savings();
			MAIN.createSavingsAcc(choice);
			break;
		case 3:
			Business bs = new Business();
			MAIN.createBusinessAcc(choice);
			break;
		default: 
			System.out.println("\nSorry, that was an invaild selection. Please try again.");
			createAccount();
			break;
		}	
	}
}
