package Test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import logic_layer.Order;
import logic_layer.RentalRecord;
import logic_layer.Worker;

public class Event_test1
	{

		RentalRecord mockedRR= new RentalRecord();
		Worker mockedWorker=new Worker();	
		Order mockedOrder=new Order();
		String event= "Worker 14434534";
		
		
		public void testEquals(){
			assertEquals(event, mockedOrder.getOrderNumber());
		}
	}
