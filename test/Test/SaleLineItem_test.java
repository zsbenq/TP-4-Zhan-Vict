package Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import data_layer.DataModel;
import exceptions.CopyNotFoundException;
import exceptions.PatronNotFoundException;
import logic_layer.Copy;
import logic_layer.Patron;
import logic_layer.RentalLineItem;
import logic_layer.SaleLineItem;

public class SaleLineItem_test
	{
		String title="The Hunger Games";
		String copyID="45078";
		Copy mockedCopy;
		String copy=null;
		Patron mockedPatron;
		SaleLineItem mockedSale;
		Patron PatronID;

		
//		@Test
//		public void getCopyId() {
//			assertNull(copyID, mockedCopy.getCopyID());
//		}
		

		@Test (expected=CopyNotFoundException.class)
		public void getCopyID() throws CopyNotFoundException{
			mockedCopy = new Copy().getCopybyId(copyID);	
		}

		
		@Test
		public void test() {
			assertEquals(mockedPatron,PatronID);
			}
		
		}
	
