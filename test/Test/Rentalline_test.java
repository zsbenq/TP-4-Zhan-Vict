package Test;

import static org.junit.Assert.assertEquals;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import exceptions.CopyNotFoundException;
import logic_layer.Copy;
import logic_layer.RentalLineItem;

public class Rentalline_test
	{
		static String isbn="555555";
		static String title="The adventures of Tom Saywer";
		static String holddays="10";
		String copyId="12224";
		static Copy mockedCopy=new Copy();
//		RentalLineItem mockedRLI=new RentalLineItem(copyId); // cannot figure out how to get this to work
		
	    
	    //this works
	    @Test (expected=CopyNotFoundException.class)
	    public void CopyNotFoundExceptionWithCopyID() throws CopyNotFoundException{
	    	mockedCopy.getCopybyId(copyId);
	    }
	    
	    @Test 
	    public void testGetters(){
//	    	mockedRLI.getHoldDays();
//	    	mockedRLI.getTitle();
//	    	mockedRLI.getCopyId();
//	    	mockedRLI.getCopyId();
//	    	mockedRLI.isCopyAvailable();
	    }
	}
