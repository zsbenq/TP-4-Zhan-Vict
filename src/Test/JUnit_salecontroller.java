package Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import data_layer.FakeDatabase;
import exceptions.CopyNotFoundException;
import logic_layer.Copy;
import logic_layer.Order;
import logic_layer.ParameterBox;
import logic_layer.Receipt;
import logic_layer.SaleController;
import logic_layer.SaleLineItem;

public class JUnit_salecontroller
	{
		static SaleController mockedSC = mock(SaleController.class);
		private static ParameterBox mockedparamBox=mock(ParameterBox.class);
		private static ParameterBox mockedPack=mock(ParameterBox.class);
		private static ParameterBox pack=new ParameterBox();
		private static String paymentMethod;
	
	public static void setUp()
	{
	
		when(mockedSC.packSaleCopyInfo().thenReturn(pack));
}
	@Test{
	
	}
	}
