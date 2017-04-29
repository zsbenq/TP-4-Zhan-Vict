package Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;

import data_layer.DataModel;
import data_layer.FakeDatabase;
import exceptions.CopyNotFoundException;
import exceptions.PaymentFailException;
import logic_layer.Order;
import logic_layer.ParameterBox;
import logic_layer.Patron;
import logic_layer.Payment;
import logic_layer.Receipt;
import logic_layer.SaleLineItem;

public class Order_test
	{
	    static Order mockedOrder = mock(Order.class);
	    static Receipt mockReceipt=mock(Receipt.class);
	    SaleLineItem mockItem = null;
	    private static String copyId="0000";
	    static Payment mockedPayment=mock(Payment.class);
	    static ParameterBox mockedPB=mock(ParameterBox.class);
	    static Payment payment1=null;
	    static Patron patron;
	    String orderNumber="12391823190";
	    String item="Book";
	    
	    //set up methods
		 public Payment getPayment(){
					if(payment1 == null){
						this.mockedPayment = new Payment();
					}
					return this.mockedPayment;
					
				}
		
		// actual implementation of tests
		@Test
		public void testIfNull(){
			assertNull(mockItem);}
		 
		@Test
		public void testVoid(){
		//mockedOrder.generateReceipt(); // tested with public visibility 
		mockedOrder.addPatron(patron);
		}
		
		@Test
		public void assertTest(){
			assertEquals(orderNumber, mockedOrder.getOrderNumber());
			assertEquals(item, mockedOrder.getItemPrice());
			assertEquals(item, mockedOrder.getItemName());  // will return false because it is not null
		}
		
		
			}

		

		
		
		
	
		
