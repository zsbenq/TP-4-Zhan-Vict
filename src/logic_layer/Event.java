package logic_layer;

public class Event {


	public void recordRentalEvent(RentalRecord record) {
		String event = "Worker: " + new Worker().whoisWorking() + "\n";
		event += "Event: Rental\n";
		event += "RecordId: " + record.getRecordId() + "\n";
		writeEventToFile(event);
	}
	
	public void recordPaymentEvent(Order order) {
		String event = "Worker: " + new Worker().whoisWorking() + "\n";
		event += "Event: Payment\n";
		event += "OrderNumber: " + order.getOrderNumber() + "\n";
		writeEventToFile(event);
	}

	private void writeEventToFile(String event) {
		//do not implement, out of scope
		return ;
	}

	
}
