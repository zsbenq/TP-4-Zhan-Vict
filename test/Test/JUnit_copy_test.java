package Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import data_layer.DataModel;
import exceptions.CopyNotFoundException;
import logic_layer.Copy;
import logic_layer.ParameterBox;
public class JUnit_copy_test
	{
		private static String isbn="555555";
		private static String title="The adventures of Tom Saywer";
		private static String copyId="455";

	    static Copy mockedCopy = mock(Copy.class);
	    
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
		 
	}
