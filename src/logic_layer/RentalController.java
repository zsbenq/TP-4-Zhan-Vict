package logic_layer;

import exceptions.CopyNotFoundException;

public class RentalController {
	Patron currentPatron = null;
	RentalRecord record = null; 
	UIServiceProvideInterface uiService = null;
	private static final int CHECKOUTPROCESS = 1;
	private static final int CHECKINPROCESS = 2;
	private int currentProcess = 0;
	String currentCopyId = "";
	
	
	RentalController(UIServiceProvideInterface Spi){
		this.uiService = Spi;
		setRecord(new RentalRecord());
	}
	
	public void startCheckIn() {
		setCurrentProcess(CHECKINPROCESS);
		noticeUIGetCopyID();
	}
	
	public void startCheckOut() {
		setCurrentProcess(CHECKOUTPROCESS);
		noticeUIGetPatronID();
	}
	
	public void enterPartonId(String patronId){
		try{
			Patron patron = new Patron().getPatron(patronId);
			setCurrentPatron(patron);
			getRecord().addPatron(patron);
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
		param.add("patronid", getCurrentPatron().getPatronId());
		param.add("patronname", getCurrentPatron().getPatronName());
		uiService.displayPatronInfo(param);
		
	}

	private void noticeUIPatronIdError() {
		uiService.displayPatronIdError();
		
	}
	
	public void enterCopyId(String copyId){
		try {
			setCurrentCopyId(copyId);
			if(getCurrentProcess() == CHECKOUTPROCESS) {
				getRecord().addItemtoRecord(copyId);
				noticeUICheckOutInfo();
			}else if(getCurrentProcess() == CHECKINPROCESS) {
				getRecord().returnCopy(copyId);
				notifyStoreReturnCopy(copyId);
				noticeUICheckInComplete();
			}
		}catch(Exception e) {
			noticeUICopyIdError();
		}
	}

	private void notifyStoreReturnCopy(String copyId) throws CopyNotFoundException {
		Store store = new Store();
		store.returnCopy(copyId);
	}

	private void noticeUICheckInComplete() {
		uiService.displayCheckInComplete();
		
	}


	private void noticeUICheckOutInfo() {
		try{
			ParameterBox param = new ParameterBox();
			param.add("copytitle", getRecord().getItemName());
			param.add("copyduedate", getRecord().getDueDate());
			uiService.displayCheckOutInfo(param);
		}catch(CopyNotFoundException e){
			noticeUICopyIdError();
		}
		
		
	}

	private void noticeUICopyIdError() {
		uiService.displayCopyIdError();
		
	}
	
	public void completeCheckOut() {
		try{
			getRecord().completeCheckOut();
			notifyStoreRemoveCopy();
			noticeEvent();
			noticeUICheckOutComplete();
			finishProcess();
		}catch(CopyNotFoundException e){
			noticeUICopyIdError();
		}
	}
	
	private void notifyStoreRemoveCopy() throws CopyNotFoundException {
		Store store = new Store();
		store.removeCopy(getCurrentCopyId());
	}

	private void noticeUICheckOutComplete() {
		uiService.displayCheckOutComplete();
		
	}

	private void noticeEvent() {
		new Event().recordRentalEvent(getRecord());
	}
	
	private void finishProcess() {
		setCurrentProcess(0);
		setCurrentPatron(null);
		setRecord(null);
		setCurrentCopyId(null);
	}
	

	private Patron getCurrentPatron() {
		return currentPatron;
	}

	private void setCurrentPatron(Patron currentPatron) {
		this.currentPatron = currentPatron;
	}

	private RentalRecord getRecord() {
		return record;
	}

	private void setRecord(RentalRecord record) {
		this.record = record;
	}

	public int getCurrentProcess() {
		return currentProcess;
	}

	public void setCurrentProcess(int currentProcess) {
		this.currentProcess = currentProcess;
	}

	private String getCurrentCopyId() {
		return currentCopyId;
	}

	private void setCurrentCopyId(String currentCopyId) {
		this.currentCopyId = currentCopyId;
	}

}
