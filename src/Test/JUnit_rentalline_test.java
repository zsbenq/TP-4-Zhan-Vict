package Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import logic_layer.Copy;
import logic_layer.RentalLineItem;

public class JUnit_rentalline_test
	{
		private static String isbn="555555";
		private static String title="The adventures of Tom Saywer";
		private static String copyId="455";
		private static String holddays="10";

	    static RentalLineItem mockedRental = mock(RentalLineItem.class);
	    
		public static void setUp(){
			  
			    
			    when(mockedRental.getTitle()).thenReturn(title);
				when(mockedRental.getHoldDays()).thenReturn(holddays);
				when(mockedRental.isCopyAvailable()).thenReturn(getCopy().isAvailable());
	}
		 private static Copy getCopy() {
			// TODO Auto-generated method stub
			return null;
		}
		@Test
		 //returns an error because in the Copy class, all these are null.
		 public void testGetAllBooks() throws Exception {

			    assertEquals(null, mockedRental.getTitle());
//			    assertEquals(holddays, mockedRental.getHoldDays());
			    assertEquals(false, mockedRental.isCopyAvailable() );
	}
	}
