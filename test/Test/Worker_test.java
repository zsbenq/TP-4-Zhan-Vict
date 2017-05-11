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
		static String name="Jorge";
		String workID = "50505050";
		static String currentWorker="Sheila";
		
		@Test
		public void testEquals(){
		// expect null
		assertEquals(name, mockedWorker.getName());
		assertEquals(currentWorker, mockedWorker.whoisWorking());
		}
		
		@Test
		public void assertFail(){
			// Testing different variables. Expect test to fail.
			assertEquals(name, mockedWorker.getWorkID());
		}
		
		@Test
		public void test_Worker()
		{
			Worker w = new Worker();
			w.setName("abc");
			w.setWorkID("1");
			assertEquals("abc", w.getName());
			assertEquals("1", w.getWorkID());
			w.startWork();
			
		}
	}
