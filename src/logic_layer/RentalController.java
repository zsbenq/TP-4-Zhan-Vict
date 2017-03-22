package logic_layer;

import java.util.ArrayList;

import exceptions.CopyNotFoundException;
import exceptions.PatronNotFoundException;

public class RentalController {
	Patron currentPatron = null;
	RentalRecord record = null; 
	private static final int CHECKOUTPROCESS = 1;
	private static final int CHECKINPROCESS = 2;
	private int currentProcess = 0;
	String currentCopyId = "";
	
	
	public void startCheckIn() {
		setCurrentProcess(CHECKINPROCESS);
		setRecord(new RentalRecord());
	}
	
	public void startCheckOut() {
		setCurrentProcess(CHECKOUTPROCESS);
		setRecord(new RentalRecord());
	}
	
	public ParameterBox enterPartonId(String patronId) throws PatronNotFoundException{
		Patron patron = new Patron().getPatron(patronId);
		setCurrentPatron(patron);
		getRecord().addPatron(patron);
		return packPatronInfo();
	}

	private ParameterBox packPatronInfo() {
		ParameterBox param = new ParameterBox();
		param.add("patronid", getCurrentPatron().getPatronId());
		param.add("patronname", getCurrentPatron().getPatronName());
		return param;
	}

	
	public ParameterBox enterCopyId(String copyId) throws CopyNotFoundException{
		setCurrentCopyId(copyId);
		if(getCurrentProcess() == CHECKOUTPROCESS) {
			getRecord().addItemtoRecord(copyId);
			return packCheckOutInfo();
		}else if(getCurrentProcess() == CHECKINPROCESS) {
			getRecord().returnCopy(copyId);
			notifyStoreReturnCopy(copyId);
			return packCheckInComplete();
		}
		return new ParameterBox();
	}

	private void notifyStoreReturnCopy(String copyId) throws CopyNotFoundException {
		Store store = new Store();
		store.returnCopy(copyId);
	}

	private ParameterBox packCheckInComplete() throws CopyNotFoundException {
		ParameterBox param = new ParameterBox();
		param.add("complete", "true");
		param.add("copytitle", getRecord().getItemName());
		return param;
	}


	private ParameterBox packCheckOutInfo() throws CopyNotFoundException {
		ParameterBox param = new ParameterBox();
		param.add("copytitle", getRecord().getItemName());
		param.add("copyduedate", getRecord().getDueDate());
		return param;
	}

	public ParameterBox getPatronAllRentalRecords(String patronId) throws CopyNotFoundException {
		return	getRecord().getAllRentalRecords(patronId);
	}

	public void completeCheckOut() throws CopyNotFoundException {
		getRecord().completeCheckOut();
		notifyStoreRemoveCopy();
		noticeEvent();
		finishProcess();
	}
	
	private void notifyStoreRemoveCopy() throws CopyNotFoundException {
		Store store = new Store();
		store.removeCopy(getCurrentCopyId());
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
