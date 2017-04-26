package logic_layer;

import exceptions.CopyNotFoundException;
import exceptions.PatronNotFoundException;
import exceptions.PaymentFailException;

public class SaleController {
	Patron currentPatron = null;
	Order order = null;
	
	public void startSale(){
		setOrder(new Order());
	}
	
	public ParameterBox enterPartonId(String patronId) throws PatronNotFoundException{
		Patron patron = new Patron().getPatron(patronId);
		this.currentPatron = patron;
		this.order.addPatron(this.currentPatron);
		return packPatronInfo();
	}
	
	private ParameterBox packPatronInfo() {
		ParameterBox param = new ParameterBox();
		param.add("patronid", this.currentPatron.getPatronId());
		param.add("patronname", this.currentPatron.getPatronName());
		return param;
	}


	public ParameterBox enterCopyId(String copyId) throws CopyNotFoundException{
		this.order.addItemtoOrder(copyId);
		return packSaleCopyInfo();
	}


	private ParameterBox packSaleCopyInfo() {
		ParameterBox param = new ParameterBox();
		param.add("copytitle", this.order.getItemName());
		param.add("copyprice", this.order.getItemPrice());
		return param;
	}

	public ParameterBox makePayment(String paymentMethod) throws PaymentFailException{
		this.order.payOrder(paymentMethod);
		noticeEvent();
		ParameterBox pack = packReceipt();
		finishProcess();
		return pack;
	}
	

	private void noticeEvent() {
		Event event = new Event();
		event.recordPaymentEvent(this.order);
	}

	private ParameterBox packReceipt() {
		Receipt receipt = this.order.getReceipt();
		ParameterBox param = new ParameterBox();
		param.add("receiptitemname", receipt.getItemName());
		param.add("receiptitemprice", receipt.getItemPrice());
		param.add("receiptordernumber", receipt.getOrderNumber());
		param.add("receiptpaydate", receipt.getPayDate());
		param.add("receiptpaymentmethod", receipt.getPaymentMethod());
		return param;

	}
	
	private void finishProcess() {
		setCurrentPatron(null);
		setOrder(null);
	}

	private void setCurrentPatron(Patron currentPatron) {
		this.currentPatron = currentPatron;
	}

	private void setOrder(Order order) {
		this.order = order;
	}
}
