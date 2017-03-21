package logic_layer;


import data_layer.DataModel;
import exceptions.CopyNotFoundException;
import exceptions.PaymentFailException;

public class Order {
	private SaleLineItem item = null;
	private static String orderNumber = "";
	private Receipt receipt = null;
	private Patron patron = null;
	
	Order(){
		getNewOrderNumber();
	}
	
	private void getNewOrderNumber() {
		try{
			String number = new DataModel().getNewOrderNumber();
			this.orderNumber = number;
		}catch(Exception e){
			this.orderNumber = "0";
		}
		
	}

	public void payOrder(String paymentMethod) throws PaymentFailException{
		new Payment().makePayment();
		saveOrdertoData();
		generateReceipt();
	}
	
	private void generateReceipt() {
		// TODO Auto-generated method stub
		// set all the attributes of receipt
	}

	private void saveOrdertoData() {
		ParameterBox orderData = packOrderData();
		new DataModel().saveOrder(orderData);
		
	}

	private ParameterBox packOrderData() {
		ParameterBox dataPackage = new ParameterBox();
		dataPackage.add("ordernumber", this.orderNumber);
		dataPackage.add("orderitem", this.item.getTitle());
		dataPackage.add("orderprice", this.item.getPrice());
		dataPackage.add("orderpaydate", this.receipt.getPayDate());
		dataPackage.add("orderpaymentmethod", this.receipt.getPaymentMethod());
		return dataPackage;
	}

	public void addItemtoOrder(String copyId) throws CopyNotFoundException {
		item = new SaleLineItem(copyId);
	}
	

	public void addPatron(Patron patron) {
		this.patron = patron;
		
	}

	public String getItemName() {
		return this.item.getTitle();
	}

	public String getItemPrice() {
		// TODO Auto-generated method stub
		return null;
	}


	public Receipt getReceipt() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
