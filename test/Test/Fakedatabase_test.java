package Test;
import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

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
		FakeDatabase mockDatabase;
		Copy mockCopy;
		Textbook mockTextbook;
		String title="Life and Fate";
		String price="15.99";
		String author="Vasily Grossman";
		String holdDays="15";
		
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
			assertNull("Life and Fate", textbook1.get(title));
			assertNull("15.99", textbook1.get(price));
			assertNull("Vasily Grossman", textbook1.get(author));
			assertNull("15", textbook1.get(holdDays));
		}
		
		@Test
		public void initiatePatron() {
			Map<String, String> patron = new HashMap<String, String>();
			patron.put("patronid", "001");
			patron.put("name", "Mr. Software");
		}
	
		}
	
