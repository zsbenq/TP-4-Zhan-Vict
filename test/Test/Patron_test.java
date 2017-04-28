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

public class Patron_test
	{
		private static String id = null;
		static Patron mockedPatron = mock(Patron.class);
		static String patronID="0123567";
		static ParameterBox mockedPB=mock(ParameterBox.class);
		static String patronName="George";
		
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
		
		@Test (expected=PatronNotFoundException.class)
		public void testGetPatronFromData() throws PatronNotFoundException{
			ParameterBox dataPack = new DataModel().getPatronbyId(id);
			unpackPatronData(dataPack);
		}

		@Test (expected=PatronNotFoundException.class)
		public void unpackPatronData(ParameterBox dataPack) throws PatronNotFoundException {
			if(dataPack.isEmpty()){
				throw new PatronNotFoundException("patron id: " + this.id + " is not found");
			}else{
				this.id = dataPack.get("patronid");
				Patron_test.patronName = dataPack.get("patronname");
			}
	}
	}
