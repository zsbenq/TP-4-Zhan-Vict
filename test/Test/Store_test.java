package Test;
import exceptions.CopyNotFoundException;
import exceptions.PatronNotFoundException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mock;

import exceptions.CopyNotFoundException;
import logic_layer.Copy;
import logic_layer.Patron;
import logic_layer.RentalLineItem;
import logic_layer.RentalRecord;
import logic_layer.Store;


public class Store_test
	{
		static Store mockedStore = mock(Store.class);
		String copyID="4560801";
		
		@Test (expected=CopyNotFoundException.class)
		public void returnCopy() throws CopyNotFoundException {
			Copy returnedCopy = new Copy().getCopybyId(copyID);
			returnedCopy.goInStock();
	}
	}
