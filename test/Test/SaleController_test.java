package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.CopyNotFoundException;
import exceptions.PatronNotFoundException;
import exceptions.PaymentFailException;
import exceptions.TextbookNotFoundException;
import logic_layer.Order;
import logic_layer.ParameterBox;
import logic_layer.Patron;
import logic_layer.Receipt;
import logic_layer.SaleController;
import static org.mockito.Mockito.*;
public class SaleController_test

	{
		static String patronID="00056";
		static String copyId="13-14567893424";
		static String paymentMethod="cash";
		static SaleController mockedSC=new SaleController();
		static ParameterBox mockedPB;
		static Receipt mockedReceipt;
		Patron currentPatron;
		Order order;

		
//		public void finishProcess() {
//		setCurrentPatron(null);
//		setOrder(null);
//			}
		
		public void setCurrentPatron(Patron currentPatron) {
			this.currentPatron = currentPatron;
		}
		
		@Test
		public ParameterBox packReceipt() {
			mockedReceipt = this.order.getReceipt();
			ParameterBox param = new ParameterBox();
			param.add("receiptitemname", mockedReceipt.getItemName());
			param.add("receiptitemprice", mockedReceipt.getItemPrice());
			param.add("receiptordernumber", mockedReceipt.getOrderNumber());
			param.add("receiptpaydate", mockedReceipt.getPayDate());
			param.add("receiptpaymentmethod", mockedReceipt.getPaymentMethod());
			return param;

		}

		@Test (expected=PatronNotFoundException.class)
		public void test_enterPartonId() throws PatronNotFoundException{
			Patron patron = new Patron().getPatron(patronID);
			mockedSC.startSale();
			mockedSC.enterPartonId("00056");
		}
		
		@Test (expected=PaymentFailException.class)
		public ParameterBox makePayment() throws PaymentFailException{
			this.order.payOrder(paymentMethod);
//			mockedSC.noticeEvent();
			ParameterBox pack = packReceipt();
//			finishProcess();
			return pack;
		}
//		@Test 
//		public void addParameters(){
//			Receipt receipt = this.order.getReceipt();
//			ParameterBox mockedPB = new ParameterBox();
//			mockedPB.add("patronid", this.currentPatron.getPatronId());
//			mockedPB.add("patronname", this.currentPatron.getPatronName());
//		}
		
		@Test
		public void testEnterPID()
		{
			try {
				mockedSC.enterPartonId("001");
			} catch (PatronNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Test
		public void testEnterCID()
		{
			try {
				mockedSC.enterCopyId("");
			} catch (CopyNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Test
		public void testMakePayment()
		{
			try {
				mockedSC.makePayment("cash");
			} catch (PaymentFailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Test
		public void testStartSale()
		{
			mockedSC.startSale();
		}
	}
