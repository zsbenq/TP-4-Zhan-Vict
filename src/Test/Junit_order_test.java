package Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import data_layer.FakeDatabase;
import exceptions.CopyNotFoundException;
import logic_layer.Order;
import logic_layer.Receipt;
import logic_layer.SaleLineItem;

public class Junit_order_test
	{
	    static Order mockedOrder = mock(Order.class);
	    static Receipt mockReceipt=mock(Receipt.class);
	    SaleLineItem mockItem = null;
	    private static String copyId="0000";
	
	    
		 public static void setUp(){
		when(mockedOrder.getReceipt()).thenReturn(mockReceipt);
		
	}
		 @Test
		 //??
		public void testIfNull(){
			assertNull(mockItem);
			}	

		}
		
		
	
		
