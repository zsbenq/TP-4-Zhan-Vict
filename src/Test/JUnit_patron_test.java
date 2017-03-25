package Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import exceptions.PatronNotFoundException;
import logic_layer.Patron;
import logic_layer.RentalLineItem;

public class JUnit_patron_test
	{
		private static final String id = null;
		static Patron mockedPatron = mock(Patron.class);
		static String patronID;
		
		public void mockedPatronID(String patronID){
			String id = null;
			this.patronID = id;
		}
		
		public void setUptoTest(){
			
		when(mockedPatron.getPatronId()).thenReturn(patronID);
		
		}
		
		@Test
		public void testPatron() {
			assertEquals(null, patronID);
			assertEquals(patronID, id);
			
		}

	}
