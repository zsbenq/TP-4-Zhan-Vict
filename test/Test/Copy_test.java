package Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import data_layer.DataModel;
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
		static Textbook textbook = null;
		String holddays="60";
		String price="59";
		String condition="good";

	    static Copy mockedCopy = mock(Copy.class);
	    static CopyNotFoundException mockedCNotFound=mock(CopyNotFoundException.class);
	    static Textbook mockedTextbook=mock(Textbook.class);
	    
		 public static void setUp(){

			    when(mockedCopy.getTitle()).thenReturn(title);
				when(mockedCopy.getCopyID()).thenReturn(copyId);
				when(mockedCopy.getISBN()).thenReturn(isbn);
		 }
				@Test
				 //returns an error because in the Copy class, all these are null.
				 public void testGetAllBooks() throws Exception {

					    assertEquals("The adventures of Tom Saywer", mockedCopy.getTitle());
					    assertEquals("555555", mockedCopy.getISBN());
					    assertEquals("455", mockedCopy.getCopyID());
					    
					  }
				 
				 @Test
				 public void testGetters(){
					 	//note: methods changed to public
					 	mockedCopy.getTextbook();
					 	mockedCopy.getISBN();
					 	mockedCopy.getPrice();
					 	
						
					assertEquals(price, mockedCopy.getPrice());
					assertEquals(isbn, mockedCopy.getTextbook().getIsbn());
					assertEquals(holddays, mockedCopy.getTextbook().getHoldDays());
					  
				 }
				 
				
				
	}
		 
		 

