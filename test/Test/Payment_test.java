package Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


import org.junit.Test;
import org.junit.Assert;


import data_layer.DataModel;
import exceptions.PatronNotFoundException;
import logic_layer.ParameterBox;
import logic_layer.Patron;
import logic_layer.Payment;
import logic_layer.RentalLineItem;
public class Payment_test
	{
		String paymentMethod="cash";
		String payDate="April 25";
		Payment mockedPayment=new Payment();
		String newPayment;
		
			
		@Test
		public void returnTest() {
			mockedPayment.getPayDate();
			mockedPayment.getMethod();
	}
	
	
	}
