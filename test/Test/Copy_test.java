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
		static String isbn="555555";
		static String title="The adventures of Tom Saywer";
		static String copyId="455";
		private Textbook textbook = null;

	    static Copy mockedCopy = mock(Copy.class);
//	    //static TextbookNotFoundException mockedTBNotFound=mock(TextbookNotFoundException.class);
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
		 
		 
		 @Test(expected = TextbookNotFoundException.class ) // will fail
		    public void throwsDifferentExceptionThanExpected() throws TextbookNotFoundException {
		        //mockedCopy.getTextbookbyISBN(isbn);
		    }
				
			
		}
		 

