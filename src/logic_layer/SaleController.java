package logic_layer;


public class SaleController {
	Patron currentPatron = null;
	Order order = null;
	UIServiceProvideInterface uiService = null;
	
	SaleController(UIServiceProvideInterface Spi){
		this.uiService = Spi;
	}
	
	public void startSale(){
		setOrder(new Order());
		noticeUIGetPatronID();
	}
	
	public void enterPartonId(String patronId){
		try{
			Patron patron = new Patron().getPatron(patronId);
			this.currentPatron = patron;
			this.order.addPatron(this.currentPatron);
			noticeUIPatronInfo();
			noticeUIGetCopyID();
		}catch(Exception e){
			noticeUIPatronIdError();
		}
		
	}
	
	private void noticeUIGetCopyID() {
		uiService.getCopyIDfromUserInput();
		
	}
	
	private void noticeUIGetPatronID() {
		uiService.getPatronIDfromUserInput();
		
	}

	private void noticeUIPatronInfo() {
		ParameterBox param = new ParameterBox();
		param.add("patronid", this.currentPatron.getPatronId());
		param.add("patronname", this.currentPatron.getPatronName());
		uiService.displayPatronInfo(param);
		
	}

	private void noticeUIPatronIdError() {
		uiService.displayPatronIdError();
		
	}

	public void enterCopyId(String copyId){
		try{
			this.order.addItemtoOrder(copyId);
			noticeUISaleCopyInfo();
			noticeUIGetPaymentMethod();
		}catch(Exception e){
			noticeUICopyIdError();
		}
	}
	
	private void noticeUIGetPaymentMethod() {
		uiService.displayPaymentMethod();
		
	}

	private void noticeUISaleCopyInfo() {
		ParameterBox param = new ParameterBox();
		param.add("copytitle", this.order.getItemName());
		param.add("copyprice", this.order.getItemPrice());
		uiService.displaySaleCopy(param);
		
	}

	private void noticeUICopyIdError() {
		uiService.displayCopyIdError();
		
	}

	public void makePayment(String paymentMethod){
		try{
			this.order.payOrder(paymentMethod);
			noticeEvent();
			noticeUIReceipt();
			finishProcess();
		}catch(Exception e){
			noticeUIPaymentFail();
		}
		
	}

	private void noticeUIPaymentFail() {
		uiService.displayPaymentFail();
	}

	private void noticeEvent() {
		Event event = new Event();
		event.recordPaymentEvent(this.order);
	}

	private void noticeUIReceipt() {
		Receipt receipt = this.order.getReceipt();
		ParameterBox param = new ParameterBox();
		param.add("receiptitemname", receipt.getItemName());
		param.add("receiptitemprice", receipt.getItemPrice());
		param.add("receiptordernumber", receipt.getOrderNumber());
		param.add("receiptpaydate", receipt.getPayDate());
		param.add("receiptpaymentmethod", receipt.getPaymentMethod());
		uiService.displayReceipt(param);

	}
	
	private void finishProcess() {
		setCurrentPatron(null);
		setOrder(null);
	}

	private Patron getCurrentPatron() {
		return currentPatron;
	}

	private void setCurrentPatron(Patron currentPatron) {
		this.currentPatron = currentPatron;
	}

	private Order getOrder() {
		return order;
	}

	private void setOrder(Order order) {
		this.order = order;
	}
}
