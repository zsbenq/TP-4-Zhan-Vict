package ui_layer;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import logic_layer.TRLInterface;

public class ActionDispatcher {
	private static final int MINIMUMOPTION = 1;
	private static final int MAXIMUMINPUTLENGTH = 20;
	public static final int PATRONID = 1;
	public static final int COPYID = 2;
	public static final int PAGE_MAINMENU = 1;
	public static final int PAGE_PAYMENT = 2;
	public static final int PAGE_CONFIRM_CHECK_OUT = 3;
	public static final int OPTIONS_MAINMENU = 4;
	public static final int OPTIONS_PAYMENT = 2;
	public static final int OPTIONS_CONFIRM_CHECK_OUT = 1;
	public static final int OPTION_MAINMENU_CHECK_IN = 1;
	public static final int OPTION_MAINMENU_CHECK_OUT = 2;
	public static final int OPTION_MAINMENU_SELL_COPY = 3;
	public static final int OPTION_MAINMENU_PATRON_RECORD = 4;
	public static final int OPTION_PAYMENT_CASH = 1;
	public static final int OPTION_PAYMENT_CREDITCARD = 2;
	public static final int OPTION_CONFIRM_CHECK_OUT = 1;
	private TRLInterface systemInterface = null;
	
	public void bindSystemInterface(TRLInterface iTRL) {
		systemInterface = iTRL;
	}
	
	private String captureUserInput()
	{
		try{
			String userInput = StdIn.readString();
			while(userInput.length() > MAXIMUMINPUTLENGTH || userInput.length() == 0)
			{
				StdOut.println("Input is invalid");
				userInput = StdIn.readString();
			}
			return userInput;
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		return null;
		
	}
	
	private int captureUserSelection(int optionAmount)
	{
		try{
			int userSelection = Integer.parseInt(StdIn.readString());
			int restriction = MINIMUMOPTION;
			while(userSelection < restriction || userSelection > optionAmount)
			{
				StdOut.println("Invalid option, try again");
				userSelection = Integer.parseInt(StdIn.readString());
			}
			return userSelection;
			
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		return 0;
	}
	
	public void getUserInput(int inputType) {
		try{
			String inputString = captureUserInput();
			if(inputString != null){
				passInputtoController(inputType, inputString);
			}
			else{
				StdOut.println("Input Error");
				getUserInput(inputType);
			}
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		
	}
	

	private void passInputtoController(int inputType, String id) {
		switch(inputType){
		case PATRONID:
			systemInterface.EnterPatronId(id);
			break;
		case COPYID:
			systemInterface.EnterCopyId(id);
			break;
		default:
			break;
		}
	}

	public void getUserSelection(int page, int sectionAmount) {
		try{
			int userSelection = captureUserSelection(sectionAmount);
			identifyPage(page, userSelection);
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
	}

	private void identifyPage(int page, int userSelection) {
		switch (page){
		case PAGE_MAINMENU:
			passMainMenuSelectiontoController(userSelection);
			break;
		case PAGE_PAYMENT:
			passPaymentSelectiontoController(userSelection);
			break;
		case PAGE_CONFIRM_CHECK_OUT:
			passComfirmCheckOutSelectiontoController(userSelection);
			break;
		default: 
			StdOut.println("Error occured");
			break;
		}
	}

	private void passComfirmCheckOutSelectiontoController(int userSelection) {
		switch (userSelection){
		case OPTION_CONFIRM_CHECK_OUT:
			systemInterface.confirmCheckOut();
			break;
		default: 
			StdOut.println("Error occured");
			break;
		}
		
		
	}

	private void passPaymentSelectiontoController(int userSelection) {
		switch (userSelection){
		case OPTION_PAYMENT_CASH:
			systemInterface.paymentMethod("Cash");
			break;
		case OPTION_PAYMENT_CREDITCARD:
			systemInterface.paymentMethod("CreditCard");
			break;
		default: 
			StdOut.println("Error occured");
			break;
		}
		
	}

	private void passMainMenuSelectiontoController(int userSelection) {
		switch (userSelection){
		case OPTION_MAINMENU_CHECK_IN:
			systemInterface.startCheckIn();
			break;
		case OPTION_MAINMENU_CHECK_OUT:
			systemInterface.startCheckOut();
			break;
		case OPTION_MAINMENU_SELL_COPY: 
			systemInterface.startSale();
			break;
		case OPTION_MAINMENU_PATRON_RECORD:
			systemInterface.CheckPatronRecord();
			break;
		default: 
			StdOut.println("Error occured");
			break;
		}
		
	}

	
  
}
