package Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.stubbing.OngoingStubbing;

import data_layer.DataModel;
import data_layer.FakeDatabase;
import exceptions.PatronNotFoundException;
import logic_layer.Copy;
import logic_layer.ParameterBox;
import logic_layer.Patron;
import logic_layer.Payment;
import logic_layer.RentalLineItem;
import logic_layer.Textbook;

public class Fakedatabase_test
	{
		FakeDatabase mockDatabase=mock(FakeDatabase.class);
		Copy mockCopy=mock(Copy.class);
		Textbook mockTextbook=mock(Textbook.class);
		
		public static ArrayList<Map<String, String>> COPY = new ArrayList<Map<String, String>>();
		public static ArrayList<Map<String, String>> TEXTBOOK = new ArrayList<Map<String, String>>();
		public static ArrayList<Map<String, String>> PATRON = new ArrayList<Map<String, String>>();
		
		@Test
		public void initiateCopy(){
			Map<String, String> copy = new HashMap<String, String>();
			copy.put("copyid", "01");
			copy.put("condition", "good");
			copy.put("isbn", "1000");
			copy.put("instock", "true");
			COPY.add(copy);
		}
		@Test
		public void initiateTextbook() {
			Map<String, String> textbook1 = new HashMap<String, String>();
			textbook1.put("title", "Clean Code");
			textbook1.put("author", "Martin");
			textbook1.put("isbn", "1000");
			textbook1.put("price", "59");
			textbook1.put("holddays", "60");
		}
		
		@Test
		public void initiatePatron() {
			Map<String, String> patron = new HashMap<String, String>();
			Map mockedMapOptions=mock(Map.class);
			when(mockedMapOptions.put("title", "The Hunger Games")).thenReturn(patron);
		}
	
		}
	
