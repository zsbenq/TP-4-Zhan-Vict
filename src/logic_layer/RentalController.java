package logic_layer;

public class RentalController {

	Patron currentPatron = new Patron();
	UIServiceProvideInterface uiService = null;
	
	RentalController(UIServiceProvideInterface Spi){
		this.uiService = Spi;
	}
	
	public void startCheckIn() {
		
	}
	
	public void startCheckOut() {
		
	}
	
	public void enterPartonId(String patronId){
		try{
			Patron patron = new Patron().getPatron(patronId);
			this.currentPatron = patron;
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

}
