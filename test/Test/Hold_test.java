package Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mock;

import data_layer.DataModel;
import exceptions.CopyNotFoundException;
import exceptions.PatronNotFoundException;
import logic_layer.Copy;
import logic_layer.Hold;
import logic_layer.ParameterBox;
import logic_layer.Patron;
import logic_layer.RentalLineItem;
import logic_layer.RentalRecord;

public class Hold_test
	{
		static Patron mockedPatron=new Patron();
		static RentalRecord mockedRR;
		static Hold mockedHold;
		static String patronID;
		static String patronName="George";
		static String holdID="0123456";
		static String dueDate="May 5";
		static String condition="average";
		static String copyID="0091";
		public RentalRecord newRecord;
		static Copy holdingcopy;
		String id="0908867";
		Copy mockedCopy= new Copy();


		
		@Test (expected=PatronNotFoundException.class)
		public void getHoldID() throws PatronNotFoundException{
			mockedPatron = new Patron().getPatron(holdID);	
		}
		

		@Test (expected=CopyNotFoundException.class)
		public void getCopyIdException() throws CopyNotFoundException{
			mockedCopy.getCopybyId(id);
		}
		
		@Test 
		public void testGetterMethods(){
			mockedCopy.getCondition();
			mockedCopy.getHoldDays();
			mockedCopy.getISBN();
			mockedCopy.getTextbook();
			
		}
		
	}
