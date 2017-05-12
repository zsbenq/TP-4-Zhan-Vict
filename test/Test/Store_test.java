package Test;
import exceptions.CopyNotFoundException;
import exceptions.PatronNotFoundException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mock;

import data_layer.FakeDatabase;
import exceptions.CopyNotFoundException;
import logic_layer.Copy;
import logic_layer.Patron;
import logic_layer.RentalLineItem;
import logic_layer.RentalRecord;
import logic_layer.Store;


public class Store_test
	{
		Store mockedStore;
		String copyID="4560801";
		
		@Test (expected=CopyNotFoundException.class)
		public void returnCopy() throws CopyNotFoundException {
			Copy returnedCopy = new Copy().getCopybyId(copyID);
			mockedStore.removeCopy(copyID);
		}
		
	
		
		@Test (expected=CopyNotFoundException.class)
		public void remove_Copy() throws CopyNotFoundException
		{
			Copy removedCopy = new Copy().getCopybyId(copyID);
			mockedStore.returnCopy("copyID");
		}
		
		@Test
		public void testRemoveCopy()
		{
			Store s = new Store();
			try {
				s.removeCopy("01");
			} catch (CopyNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Test
		public void testReturnCopy()
		{
			Store s = new Store();
			try {
				s.returnCopy("001");
			} catch (CopyNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
