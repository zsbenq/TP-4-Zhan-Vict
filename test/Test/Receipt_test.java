package Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import logic_layer.Receipt;

public class Receipt_test
	{
		static String itemName="Cheerios";
		static Receipt mockedReceipt=mock(Receipt.class);
		static String itemPrice="$2.95";
		static String payDate="May 5th";
		static String paymentMethod="Visa";
		
		
		@Test
		public void returnItems() {
			when(mockedReceipt.getItemName()).thenReturn(itemName);
			when(mockedReceipt.getItemPrice()).thenReturn(itemPrice);
			when(mockedReceipt.getPayDate()).thenReturn(payDate);
			when(mockedReceipt.getPaymentMethod()).thenReturn(paymentMethod);
		}


	}
