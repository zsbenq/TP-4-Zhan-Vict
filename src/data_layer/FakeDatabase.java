package data_layer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FakeDatabase {
	public static ArrayList<Map<String, String>> COPY = new ArrayList<Map<String, String>>();
	/*
	 * copyid
	 * condition
	 * isbn
	 * instock
	 */
	public static ArrayList<Map<String, String>> TEXTBOOK = new ArrayList<Map<String, String>>();
	/*
	 * title
	 * author
	 * isbn
	 * price
	 * holddays
	 */
	public static ArrayList<Map<String, String>> PATRON = new ArrayList<Map<String, String>>();
	/*
	 * patronid
	 * name
	 */
	public static ArrayList<Map<String, String>> ORDER = new ArrayList<Map<String, String>>();
	/*
	 * orderid
	 * isbn
	 * copyid
	 * price
	 * paydate
	 * paymentmethod
	 */
	public static ArrayList<Map<String, String>> RECORD = new ArrayList<Map<String, String>>();
	/*
	 * recordid
	 * copyid
	 * title
	 * duedate
	 * patronid
	 * isreturned
	 */
	
	
	public FakeDatabase() {
		initiateCopy();
		initiateTextbook();
		initiatePatron();
	}
	
	private void initiateCopy() {
		Map<String, String> copy1 = new HashMap<String, String>();
		copy1.put("copyid", "01");
		copy1.put("condition", "good");
		copy1.put("isbn", "1000");
		copy1.put("instock", "true");
		
		Map<String, String> copy2 = new HashMap<String, String>();
		copy2.put("copyid", "02");
		copy2.put("condition", "good");
		copy2.put("isbn", "1100");
		copy2.put("instock", "true");
		
		Map<String, String> copy3 = new HashMap<String, String>();
		copy3.put("copyid", "03");
		copy3.put("condition", "good");
		copy3.put("isbn", "1000");
		copy3.put("instock", "true");
		
		COPY.add(copy1);
		COPY.add(copy2);
		COPY.add(copy3);
	}
	
	private void initiateTextbook() {
		Map<String, String> textbook1 = new HashMap<String, String>();
		textbook1.put("title", "Clean Code");
		textbook1.put("author", "Martin");
		textbook1.put("isbn", "1000");
		textbook1.put("price", "59");
		textbook1.put("holddays", "60");
		
		Map<String, String> textbook2 = new HashMap<String, String>();
		textbook2.put("title", "Applying UML");
		textbook2.put("author", "Larman");
		textbook2.put("isbn", "1100");
		textbook2.put("price", "99");
		textbook2.put("holddays", "900");
		
		TEXTBOOK.add(textbook1);
		TEXTBOOK.add(textbook2);
	}
	
	private void initiatePatron() {
		Map<String, String> patron = new HashMap<String, String>();
		patron.put("patronid", "001");
		patron.put("name", "Mr. Software");
		PATRON.add(patron);
	}
	
}
