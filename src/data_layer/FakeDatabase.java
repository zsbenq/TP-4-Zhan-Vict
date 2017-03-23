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
		Map<String, String> copy = new HashMap<String, String>();
		copy.put("copyid", "01");
		copy.put("condition", "good");
		copy.put("isbn", "1000");
		copy.put("instock", "true");
		COPY.add(copy);
	}
	
	private void initiateTextbook() {
		Map<String, String> textbook = new HashMap<String, String>();
		textbook.put("title", "Clean Code");
		textbook.put("author", "Martin");
		textbook.put("isbn", "1000");
		textbook.put("price", "59");
		textbook.put("holddays", "60");
		TEXTBOOK.add(textbook);
	}
	
	private void initiatePatron() {
		Map<String, String> patron = new HashMap<String, String>();
		patron.put("patronid", "001");
		patron.put("name", "Mr. Software");
		PATRON.add(patron);
	}
	
}
