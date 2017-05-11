package Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mock;

import data_layer.DataModel;
import exceptions.PatronNotFoundException;
import logic_layer.Copy;
import logic_layer.Hold;
import logic_layer.ParameterBox;
import logic_layer.Patron;
import logic_layer.RentalLineItem;
import logic_layer.RentalRecord;

public class Hold_test
	{
		static Patron mockedPatron = mock(Patron.class);
		static RentalRecord mockedRR=mock(RentalRecord.class);
		static Hold mockedHold=mock(Hold.class);
		static String patronID;
		static String patronName="George";
		static String holdID="0123456";
		static String dueDate="May 5";
		@Mock public RentalRecord newRecord;
		static Copy holdingcopy=mock(Copy.class);

		
		
		@Test
		public void testEquals() throws PatronNotFoundException{
			assertEquals(false, mockedRR.isReturned());
			assertEquals(patronID, mockedPatron.getPatron(holdID));
			assertEquals(holdingcopy.getCondition(),mockedHold.getCondition());
			when(mockedHold.isOverdue()).thenReturn(holdID);
		}

	}
