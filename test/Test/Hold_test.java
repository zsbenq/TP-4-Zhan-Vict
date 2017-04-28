package Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mock;

import data_layer.DataModel;
import exceptions.PatronNotFoundException;
import logic_layer.ParameterBox;
import logic_layer.Patron;
import logic_layer.RentalLineItem;
import logic_layer.RentalRecord;

public class Hold_test
	{
		static Patron mockedPatron = mock(Patron.class);
		static RentalRecord mockedRR=mock(RentalRecord.class);
		static String patronID="0123567";
		static String patronName="George";
		static String holdID="1505050";
		@Mock public RentalRecord newRecord;
	
		
		@Test
		public String isOverdue(){
			if(!newRecord.isReturned());
			return holdID;
		}
		
		@Test
		public void testEquals() throws PatronNotFoundException{
			assertEquals(holdID, newRecord.isReturned());
			assertEquals(patronID, mockedPatron.getPatron(holdID));
		}

	}
