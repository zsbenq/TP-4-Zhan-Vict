package Test;
import exceptions.CopyNotFoundException;
import exceptions.PatronNotFoundException;
import exceptions.TextbookNotFoundException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mock;

import exceptions.CopyNotFoundException;
import logic_layer.Copy;
import logic_layer.ParameterBox;
import logic_layer.Patron;
import logic_layer.RentalController;
import logic_layer.RentalRecord;
import logic_layer.SaleController;
import ui_layer.PageGenerator;


public class MainController_test{
	static SaleController mockedSaleController=mock(SaleController.class);
	static RentalController mockedRentalController=mock(RentalController.class);
	String inputString="22222";
	static Copy mockedCopy=mock(Copy.class);
	static String isbn="10-3010221";
	static PageGenerator mockedPageGenerator = mock(PageGenerator.class);
	

		@Test(expected = CopyNotFoundException.class )
		public void sendCopyIdtoSaleController() throws CopyNotFoundException {
			ParameterBox responsePack = mockedSaleController.enterCopyId(inputString);
			mockedPageGenerator.displaySaleCopy(responsePack);
			mockedPageGenerator.displayPaymentMethod();
		}
		
		 @Test(expected = CopyNotFoundException.class ) // testing which exception will be thrown
		    public void throwsDifferentExceptionThanExpected() throws TextbookNotFoundException, CopyNotFoundException {
				ParameterBox responsePack = mockedSaleController.enterCopyId(inputString);
		    	//mockedCopy.getTextbookbyISBN(isbn);
	}
		 @Test(expected = CopyNotFoundException.class )
		 public void sendCopyIdtoRentalController() throws CopyNotFoundException {
				ParameterBox responsePack = mockedRentalController.enterCopyId(inputString);
				if(responsePack.get("complete") == null){
					mockedPageGenerator.displayCheckOutInfo(responsePack);
				}else{
					mockedPageGenerator.displayCheckInComplete(responsePack);
				}
			}
}
