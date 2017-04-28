package Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mock;

import data_layer.DataModel;
import exceptions.PatronNotFoundException;
import logic_layer.ParameterBox;
import logic_layer.Patron;
import logic_layer.Payment;
import logic_layer.RentalLineItem;
public class Payment_test
	{
		static Payment mockedPayment=mock(Payment.class);
		static String method="cash";
		static String payDate="April 25";
		
		@Test
		public void returnTest() {
			when(mockedPayment.getPayDate()).thenReturn(payDate);
			when(mockedPayment.getMethod()).thenReturn(method);
	}
	}
