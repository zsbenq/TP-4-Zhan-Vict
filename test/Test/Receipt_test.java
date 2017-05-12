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

		@Test
		public void returnItems() {
			Receipt mockedReceipt=new Receipt();
			mockedReceipt.getItemName();
			mockedReceipt.getItemPrice();
			mockedReceipt.getPayDate();
			mockedReceipt.getPaymentMethod();
			mockedReceipt.getOrderNumber();
		}


	}
