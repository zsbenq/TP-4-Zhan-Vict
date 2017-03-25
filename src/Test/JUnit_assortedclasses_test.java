package Test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;

import exceptions.CopyNotFoundException;
import exceptions.PatronNotFoundException;
import exceptions.PaymentFailException;
import logic_layer.Copy;
import logic_layer.Hold;
import logic_layer.Patron;
import logic_layer.Payment;
import logic_layer.RentalLineItem;
import logic_layer.RentalRecord;
import logic_layer.SaleLineItem;
public class JUnit_assortedclasses_test
	{
		static Hold mockedHold = mock(Hold.class);
		static Patron mockedPatron=mock(Patron.class);
		static Patron PatronID;
		static SaleLineItem mockedSale=mock(SaleLineItem.class);
		static String price="35.99";
		static String paymentMethod;
		static Copy mockedCopy=mock(Copy.class);

		
		public String getHoldPatronID(){
			return mockedPatron.getPatronId();
		}
		
		public String getPatronID(){
			return mockedPatron.getPatronId();
		}
		
		public String getPrice(){
			return this.mockedCopy.getPrice();
		}

		
		@Test
					
		public void test() {
		mockedPatron=(PatronID);
		Mockito.doReturn(mockedCopy.getPrice()).when(mockedSale).getPrice();
		}

	}
