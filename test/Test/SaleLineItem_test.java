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
import logic_layer.Copy;
import logic_layer.Patron;
import logic_layer.RentalLineItem;
import logic_layer.SaleLineItem;

public class SaleLineItem_test
	{
		String title="The Hunger Games";
		String copyID="45078";
		static Copy mockedCopy=mock(Copy.class);
		String copy=null;
		static Patron mockedPatron=mock(Patron.class);
		static SaleLineItem mockedSale=mock(SaleLineItem.class);
		static Patron PatronID;
		
		@Rule public MockitoRule mockitoRule = MockitoJUnit.rule(); 
		
		@Test
		public void getCopyId() {
			when(mockedCopy.getCopyID()).thenReturn(copy);
		}
		

		@Test (expected=CopyNotFoundException.class)
		public void getCopyID() throws CopyNotFoundException{
			mockedCopy = new Copy().getCopybyId(copyID);	
		}
		
		@Test
		public void test() {
			mockedPatron=(PatronID);
			Mockito.doReturn(mockedCopy.getPrice()).when(mockedSale).getPrice();
			}
		
		}
	
