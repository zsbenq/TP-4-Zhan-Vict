package Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;

import data_layer.DataModel;
import data_layer.FakeDatabase;
import exceptions.CopyNotFoundException;
import exceptions.PatronNotFoundException;
import exceptions.PaymentFailException;
import logic_layer.Copy;
import logic_layer.Order;
import logic_layer.ParameterBox;
import logic_layer.Patron;
import logic_layer.Payment;
import logic_layer.Receipt;
import logic_layer.SaleLineItem;

public class Order_test
	{
	    Order mockedOrder=new Order();
	    Receipt mockReceipt;
	    SaleLineItem mockItem = null;
	    Receipt mockedReceipt=new Receipt();
	    
		
		// actual implementation of tests
		@Test
		public void testIfNull(){
			assertNull(mockItem);}
		 
		@Test
		public void testGetters(){
		mockedReceipt.getItemName();
		mockedReceipt.getPayDate();
		mockedReceipt.getPaymentMethod();
		mockedReceipt.getItemPrice();
		mockedOrder.getItemName();
		mockedOrder.getItemPrice();
		mockedOrder.getOrderNumber();
		}
		
//		@Test
//		public ParameterBox testPackOrderData() {
//			ParameterBox dataPackage = new ParameterBox();
//			dataPackage.add("ordernumber", mockedOrder.getOrderNumber());
//			dataPackage.add("ordercopyid", mockedCopy.getCopyID());
//			dataPackage.add("orderprice", mockedOrder.getItem().getPrice());
//			dataPackage.add("orderpaymentmethod", mockedOrder.getReceipt().getPaymentMethod());
//			return dataPackage;
//		}
		
		@Test
		public void testAddPatron()
		{
			Patron patron = new Patron();
			Order order = new Order();
			order.addPatron(patron);
			order.getReceipt();
		}
		
		@Test 
		public void testPayOrder()
		{
			Order order = new Order();
			try{
			order.payOrder("cash");
			}catch(Exception e){
				
			}
		}
		
		@Test
		public void testAddItemtoOrder()
		{
			Order order = new Order();
			try {
				order.addItemtoOrder("01");
			} catch (CopyNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}

		

		
		
		
	
		
