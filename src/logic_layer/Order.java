package logic_layer;


import data_layer.DataModel;
import exceptions.CopyNotFoundException;
import exceptions.PaymentFailException;

public class Order {
	private SaleLineItem item = null;
	private String orderNumber = "";
	private Receipt receipt = null;
	private Patron patron = null;
	private Payment payment = null;
	
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
		getPayment().makePayment(paymentMethod);
		saveOrdertoData();
		generateReceipt();
	}
	
	private void generateReceipt() {
		getReceipt().setItemName(getItem().getTitle());
		getReceipt().setItemPrice(getItem().getPrice());
		getReceipt().setOrderNumber(orderNumber);
		getReceipt().setPayDate(getPayment().getPayDate());
		getReceipt().setPaymentMethod(getPayment().getMethod());
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
		checkIfCopyAvailable();
	}
	
	private void checkIfCopyAvailable() throws CopyNotFoundException {
		if(!item.isCopyAvailable()){
			throw new CopyNotFoundException();
		}
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
		
		return this.item.getPrice();
	}


	public Receipt getReceipt() {
		if(this.receipt == null)
		{
			return this.receipt = new Receipt();
		}
		return this.receipt;
	}

	private SaleLineItem getItem() {
		return item;
	}

	private String getOrderNumber() {
		return orderNumber;
	}

	private void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	private Payment getPayment() {
		if(payment == null){
			this.payment = new Payment();
		}
		return this.payment;
		
	}

	private void setPayment(Payment payment) {
		this.payment = payment;
		
	}
	
}
