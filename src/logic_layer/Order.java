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
			setOrderNumber(number);
		}catch(Exception e){
			setOrderNumber("0");
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
		new DataModel().saveOrdertoDate(orderData);
		
	}

	private ParameterBox packOrderData() {
		ParameterBox dataPackage = new ParameterBox();
		dataPackage.add("ordernumber", this.getOrderNumber());
		dataPackage.add("orderisbn", this.getItem().getISBN());
		dataPackage.add("ordercopyid", this.getItem().getCopyId());
		dataPackage.add("orderprice", this.getItem().getPrice());
		dataPackage.add("orderpaydate", this.getReceipt().getPayDate());
		dataPackage.add("orderpaymentmethod", this.getReceipt().getPaymentMethod());
		return dataPackage;
	}

	public void addItemtoOrder(String copyId) throws CopyNotFoundException {
		item = new SaleLineItem(copyId);
	}
	

	public void addPatron(Patron patron) {
		this.patron = patron;
		
	}

	public String getItemName() {
		if(this.item == null)
		{
			return "";
		}
		return this.item.getTitle();
	}

	public String getItemPrice() {
		if(this.item == null)
		{
			return "";
		}
		return null;
	}


	public Receipt getReceipt() {
		if(this.receipt == null)
		{
			return new Receipt();
		}
		return null;
	}

	private SaleLineItem getItem() {
		return item;
	}

	private void setItem(SaleLineItem item) {
		this.item = item;
	}

	private static String getOrderNumber() {
		return orderNumber;
	}

	private static void setOrderNumber(String orderNumber) {
		Order.orderNumber = orderNumber;
	}

	private Patron getPatron() {
		if(patron == null)
		{
			return new Patron();
		}
		return patron;
	}

	private void setPatron(Patron patron) {
		this.patron = patron;
	}

	private void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	
	
}
