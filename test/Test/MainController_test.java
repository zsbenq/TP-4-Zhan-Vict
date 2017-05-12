package Test;
import exceptions.CopyNotFoundException;
import exceptions.PatronNotFoundException;
import exceptions.TextbookNotFoundException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mock;

import exceptions.CopyNotFoundException;
import logic_layer.Copy;
import logic_layer.MainController;
import logic_layer.ParameterBox;
import logic_layer.Patron;
import logic_layer.RentalController;
import logic_layer.RentalRecord;
import logic_layer.SaleController;
import ui_layer.PageGenerator;


public class MainController_test{
	static SaleController mockedSaleController;
	static RentalController mockedRentalController;
	static MainController mockedMC=new MainController();
	String inputString="22222";
	static Copy mockedCopy;
	static String isbn="10-3010221";
	static PageGenerator mockedPageGenerator;
	String inputPatronId;
	
	@Test (expected=PatronNotFoundException.class)
	public void getHoldID() throws PatronNotFoundException{ 
		//enterPartonId(inputPatronId));
	}
	
	@Test
	public void testEnterPatronIdinCheckIn()
	{
		MainController m = new MainController();
		m.EnterPatronId(inputPatronId);
	
	}
	
	@Test
	public void testEnterPatronIdinCheckOut()
	{
		mockedMC.startCheckOut();
		mockedMC.EnterPatronId(inputPatronId);
	}
	
	@Test
	public void testEnterPatronIdinSale()
	{
		mockedMC.startSale();
		mockedMC.EnterPatronId(inputPatronId);
	}
	
	@Test
	public void testEnterCopyId()
	{
		mockedMC.startCheckIn();
		mockedMC.EnterCopyId(inputString);
		mockedMC.startCheckOut();
		mockedMC.EnterCopyId(inputString);
		mockedMC.startSale();
		mockedMC.EnterCopyId(inputString);
	}
	
	@Test
	public void testBeginRental()
	{
		try {
			mockedMC.beginRentalProcessWithPatronId(inputPatronId);
		} catch (PatronNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CopyNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBeginSale()
	{
		try {
			mockedMC.beginSaleProcessWithPatronId(inputString);
		} catch (PatronNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
