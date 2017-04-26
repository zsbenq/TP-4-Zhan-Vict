package ui_layer;

import java.util.ArrayList;

import edu.princeton.cs.algs4.StdOut;
import exceptions.CopyNotFoundException;
import logic_layer.ParameterBox;
import logic_layer.RentalRecord;

public class PageGenerator {
	private ActionDispatcher actionDispatcher = null;
	private static final String SPLITLINE = "************";
	private static final String TABLEDASHLINE = "------------------------------";
	
	public PageGenerator(ActionDispatcher actionDispatcher){
		this.actionDispatcher = actionDispatcher;
	}
	
	public void getPatronIDfromUserInput() {
		StdOut.println("Enter patron id: (ex: 001)");
		actionDispatcher.getUserInput(ActionDispatcher.PATRONID);
	}

	public void displayPatronInfo(ParameterBox param) {
		StdOut.println("Welcome " + param.get("patronname"));
	}

	public void getCopyIDfromUserInput() {
		StdOut.println("Enter copy id: (ex: 01, 02, 03)");
		actionDispatcher.getUserInput(ActionDispatcher.COPYID);
	}

	public void displaySaleCopy(ParameterBox param) {
		StdOut.println("Selling: " + "<<" + param.get("copytitle") + ">>" + "    $" + param.get("copyprice"));
	} 

	public void displayReceipt(ParameterBox param) {
		StdOut.println(TABLEDASHLINE);
		StdOut.println("Receipt");
		StdOut.println("OrderNumber: " + param.get("receiptordernumber"));
		StdOut.println("<<" + param.get("receiptitemname") + ">>" + "    $" + param.get("receiptitemprice"));
		StdOut.println("Date: " + param.get("receiptpaydate"));
		StdOut.println("Payment Method: " + param.get("receiptpaymentmethod"));
		

	}

	public void displayPatronIdError() {
		StdOut.println("patron id is not found");

	}

	public void displayMainMenu() {
		StdOut.println(SPLITLINE+"Main Menu"+SPLITLINE);
		StdOut.println("1. Check In");
		StdOut.println("2. Check Out");
		StdOut.println("3. Sell Copy");
		actionDispatcher.getUserSelection(ActionDispatcher.PAGE_MAINMENU, ActionDispatcher.OPTIONS_MAINMENU);
	}

	public void displayCopyIdError() {
		StdOut.println("copy id is not found");
	
		
	}

	public void displayPaymentMethod() {
		StdOut.println("Select a payment method");
		StdOut.println("1. Cash");
		StdOut.println("2. Credit Card");
		actionDispatcher.getUserSelection(ActionDispatcher.PAGE_PAYMENT, ActionDispatcher.OPTIONS_PAYMENT);
	}

	public void displayPaymentFail() {
		StdOut.println("Payment Failed");
	
	}

	public void displayCheckOutInfo(ParameterBox param) {
		StdOut.println("Checking out: " + "<<" + param.get("copytitle") + ">>" + "    Due by:" + param.get("copyduedate"));
		StdOut.println("1. Comfirm");
		actionDispatcher.getUserSelection(ActionDispatcher.PAGE_CONFIRM_CHECK_OUT, ActionDispatcher.OPTIONS_CONFIRM_CHECK_OUT);
	}

	public void displayCheckOutComplete() {
		StdOut.println("Check Out Complete");
		
	}

	public void displayCheckInComplete(ParameterBox param) {
		StdOut.println("Check in " + "<<" + param.get("copytitle") + ">>" + " Complete");

	}

	public void displayPatronRecords(ParameterBox param) {
		int packSize = Integer.parseInt(param.get("size"));
		StdOut.println("History records:");
		for(int i=0; i<packSize; i++){
			StdOut.print("<<" + param.get("recorditemname"+String.valueOf(i)) + ">>");
			StdOut.print("  Due: " + param.get("recorditemduedate"+String.valueOf(i)));
			if(param.get("recordisreturned"+String.valueOf(i)).equals("true")) {
				StdOut.println(" returned");
			}else if(param.get("recordisreturned"+String.valueOf(i)).equals("false")){
				StdOut.println(" unreturned");
			}
		}
	}

}
