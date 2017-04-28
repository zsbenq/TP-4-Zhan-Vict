package Test;

import static org.mockito.Mockito.mock;

import org.junit.Test;

import logic_layer.Order;
import logic_layer.RentalRecord;
import logic_layer.Worker;

public class Event_test
	{

		RentalRecord mockedRR = mock(RentalRecord.class);
		Worker mockedWorker=mock(Worker.class);	
		Order mockedOrder=mock(Order.class);
		
		
		@Test
		public void recordRentalEvent() {
			String event = "Worker: " + new Worker().whoisWorking() + "\n";
			event += "Event: Rental\n";
			event += "RecordId: " + mockedRR.getRecordId() + "\n";
			writeEventToFile(event);
		}
		
		@Test
		public void recordPaymentEvent() {
			String event = "Worker: " + new Worker().whoisWorking() + "\n";
			event += "Event: Payment\n";
			event += "OrderNumber: " + mockedOrder.getOrderNumber() + "\n";
			writeEventToFile(event);
		}
		
		private static void writeEventToFile(String event) {
			//do not implement, out of scope
			return ;
		}
	}
