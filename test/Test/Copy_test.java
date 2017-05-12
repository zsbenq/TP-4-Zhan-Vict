package Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


import data_layer.DataModel;
import data_layer.FakeDatabase;
import exceptions.CopyNotFoundException;
import exceptions.TextbookNotFoundException;
import logic_layer.Copy;
import logic_layer.ParameterBox;
import logic_layer.Textbook;
public class Copy_test
	{
		static String isbn="1000";
		static String title="Clean Code";
		static String copyId="01";
		Textbook textbook = null;
		String holddays="60";
		String price="59";
		String condition="good";

	    static Copy mockedCopy;
	    static CopyNotFoundException mockedCNotFound;
	    static Textbook mockedTextbook;
	    
		
				@Test
				public void test_getCopy() throws CopyNotFoundException, TextbookNotFoundException
				{
					new FakeDatabase();
					Copy c = new Copy();
					c.getCopybyId("01");
					assertEquals("1000", c.getISBN());
					assertEquals("Clean Code", c.getTitle());
					c.getInStock();
					c.getHoldDays();
					c.getTextbookbyISBN(isbn);
					c.getCopyID();
					c.getPrice();
					c.getCondition();
					c.getTextbook();
					c.goInStock();
					c.goOutStock();
				}
				
	}
		 
		 

