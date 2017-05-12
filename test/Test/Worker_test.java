package Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mock;

import exceptions.PatronNotFoundException;
import logic_layer.Patron;
import logic_layer.RentalLineItem;
import logic_layer.Worker;

public class Worker_test
	{
		static Worker mockedWorker = mock(Worker.class);
		String workID = "50505050";
		static String currentWorker="Sheila";
		
		@Test
		public void testEquals(){
		// expect null
		assertNull("Jorge", mockedWorker.getName());
		assertNull("Sheila", mockedWorker.whoisWorking());
		}
		
		
		@Test
		public void test_Worker()
		{
			Worker w = new Worker();
			mockedWorker.setName("abc");
			mockedWorker.setWorkID("1");
			assertEquals(null, mockedWorker.getName());
			assertEquals(null, mockedWorker.getWorkID());
			mockedWorker.startWork();
			
		}
	}
