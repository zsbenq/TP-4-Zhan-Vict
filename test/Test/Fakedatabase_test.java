package Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.mockito.Mock;

import data_layer.DataModel;
import data_layer.FakeDatabase;
import exceptions.PatronNotFoundException;
import logic_layer.Copy;
import logic_layer.ParameterBox;
import logic_layer.Patron;
import logic_layer.Payment;
import logic_layer.RentalLineItem;

public class Fakedatabase_test
	{
		FakeDatabase mockDatabase=mock(FakeDatabase.class);
		Copy mockCopy=mock(Copy.class);
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
			Map<String, String> textbook = new HashMap<String, String>();
			textbook.put("title", "Clean Code");
			textbook.put("author", "Martin");
			textbook.put("isbn", "1000");
			textbook.put("price", "59");
			textbook.put("holddays", "60");
			TEXTBOOK.add(textbook);
		}
		
		@Test
		private void initiatePatron() {
			Map<String, String> patron = new HashMap<String, String>();
			patron.put("patronid", "001");
			patron.put("name", "Mr. Software");
			PATRON.add(patron);
		}
			
		}
	
