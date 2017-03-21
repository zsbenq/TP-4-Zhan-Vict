package logic_layer;

public class SaleController {
	Patron currentPatron = new Patron();
	Order order = new Order();
	UIServiceProvideInterface uiService = null;
	
	SaleController(UIServiceProvideInterface Spi){
		this.uiService = Spi;
	}
	
	public void startSale(){
		uiService.getPatronIDfromUserInput();
	}
	
	public void enterPartonId(String patronId){
		try{
			Patron patron = new Patron().getPatron(patronId);
			this.currentPatron = patron;
			this.order.addPatron(patron);
			noticeUIPatronInfo();
			noticeUIGetCopyID();
		}catch(Exception e){
			noticeUIPatronIdError();
		}
		
	}
	
	private void noticeUIGetCopyID() {
		uiService.getCopyIDfromUserInput();
		
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
		}catch(Exception e){
			noticeUICopyIdError();
		}
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

	public void makePayment(){
		
	}
}
