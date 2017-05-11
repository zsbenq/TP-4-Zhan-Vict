package Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mock;

import data_layer.DataModel;
import data_layer.FakeDatabase;
import exceptions.PatronNotFoundException;
import logic_layer.ParameterBox;
import logic_layer.Patron;
import logic_layer.RentalLineItem;

public class Patron_test
	{
		private static String id = null;
		static Patron mockedPatron = mock(Patron.class);
		static String patronID="0123567";
		static ParameterBox mockedPB=mock(ParameterBox.class);
		static String patronName="George";
		
		
		
		@Test
		public void thenReturnTest(){
		when(mockedPatron.getPatronId()).thenReturn(null);
		assertEquals(mockedPatron.getPatronName(), null);
		assertEquals(null, mockedPB.get("patronId"));
		}
		
		
		@Test (expected=PatronNotFoundException.class)
		public void testGetPatronFromData() throws PatronNotFoundException{
			mockedPB = new DataModel().getPatronbyId(id);
			unpackPatronData();
			}


		@Test (expected=PatronNotFoundException.class)
		public void unpackPatronData() throws PatronNotFoundException {
			if(mockedPB.isEmpty()){
				throw new PatronNotFoundException("patron id: " + this.id + " is not found");
			}else{
				this.id = mockedPB.get("patronid");
				Patron_test.patronName = mockedPB.get("patronname");
			
	}
		}
		
		@Test
		public void test_getPatron() throws PatronNotFoundException{
			new FakeDatabase();
			Patron p1 = new Patron().getPatron("001");
			Patron p2 = new Patron().getPatron("021");
			assertEquals("Mr. Software", p1.getPatronName());
			assertEquals("Mr. Software", p2.getPatronName());
		}
	}
