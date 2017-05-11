package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.CopyNotFoundException;
import exceptions.PatronNotFoundException;
import exceptions.TextbookNotFoundException;
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
		static SaleController mockedSC=mock(SaleController.class);
		static ParameterBox mockedPB=mock(ParameterBox.class);
		static Receipt mockedReceipt=mock(Receipt.class);
		Patron currentPatron;

		public ParameterBox packSaleCopyInfo() {
			ParameterBox param = new ParameterBox();
			return param;
			
		}
		

		@Test 
		public void checkReturns() throws CopyNotFoundException, PatronNotFoundException{
			when(mockedSC.enterCopyId(copyId)).thenReturn(packSaleCopyInfo());
		}


	}
