package logic_layer;

public class Order {
	Payment payOrder=new Payment();
	int orderTotal;
	
	Order(){
	
	
	}
	
	public void payOrder(){
	payOrder.makeThePayment(orderTotal);	
	}
	
	public void addItemtoOrder() {
		
	}
	
	public void printReceipt() {
		
	}
}
