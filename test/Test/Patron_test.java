package Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;

import data_layer.DataModel;
import data_layer.FakeDatabase;
import exceptions.PatronNotFoundException;
import logic_layer.ParameterBox;
import logic_layer.Patron;
import logic_layer.RentalLineItem;

public class Patron_test
	{

		Patron mockedPatron;
		ParameterBox mockedPB=new ParameterBox();
		String id="1120202";
		
		
		@Test
		public void thenReturnTest(){
		assertEquals(null, mockedPB.get("patronId"));
		}
		
		@Test 
		public void testThrownException() throws PatronNotFoundException {
			assertEquals(true, mockedPB.isEmpty());
		}

		@Test (expected=PatronNotFoundException.class)
		public void test_getGetters() throws PatronNotFoundException{
			mockedPatron.getPatronId();
			mockedPatron.getPatronName();
			Patron p1 = new Patron().getPatron("001");
			Patron p2 = new Patron().getPatron("021");
			assertEquals("Mr. Software", p1.getPatronName());
			assertEquals("Mr. Software", p2.getPatronName());
		}
		
	}
