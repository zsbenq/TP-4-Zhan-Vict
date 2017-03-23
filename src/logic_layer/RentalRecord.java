package logic_layer;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import data_layer.DataModel;
import exceptions.CopyNotFoundException;

public class RentalRecord {
	private String recordId = "";
	private RentalLineItem item = null;
	private Patron patron = null;
	public static final long DAYTIMELONG = 24*60*60*1000;
	private String dueDate = "";
	private boolean isReturned = false;
	

	RentalRecord(){
		obtainNewRecordId();
	}
	
	private void obtainNewRecordId() {
		try{
			String newid = new DataModel().getNewRecordId();
			setRecordId(newid);
		}catch(Exception e){
			setRecordId("0");
		}
		
	}
	
	public void addItemtoRecord(String copyId) throws CopyNotFoundException{
		setItem(new RentalLineItem(copyId));
		checkIfCopyAvailable();
		setDueDate(calculateDueDate());
	}
	
	private void checkIfCopyAvailable() throws CopyNotFoundException {
		if(!getItem().isCopyAvailable()){
			throw new CopyNotFoundException();
		}
	}
	
	public void returnCopy(String copyId) throws CopyNotFoundException {
		setItem(new RentalLineItem(copyId));
		DataModel model = new DataModel();
		String recordId = model.getUnreturnedRecordIdbyCopyId(copyId);
		model.updateRecordIsReturnedValue(recordId, true);
	}
	

	public ParameterBox getAllRentalRecords(String patronId) throws CopyNotFoundException {
		return new DataModel().getAllRentalRecordsbyPatronId(patronId);
	}

	public String getItemName() throws CopyNotFoundException {
		
		return getItem().getTitle();
	}


	private ArrayList<RentalRecord> unpackAllRentalRecords(ParameterBox dataPack) throws CopyNotFoundException {
		ArrayList<RentalRecord> recordArr = new ArrayList<RentalRecord>();
		int packSize = Integer.parseInt(dataPack.get("size"));
		for(int i=0; i<packSize; i++){
			RentalRecord recordfromData = new RentalRecord();
			recordfromData.setRecordId(dataPack.get("recordid"+String.valueOf(i)));
			recordfromData.getItem().setItemName(dataPack.get("recorditemname"+String.valueOf(i)));
			recordfromData.setDueDate(dataPack.get("recorditemduedate"+String.valueOf(i)));
			if(dataPack.get("recordisreturned"+String.valueOf(i)).equals("true")) {
				recordfromData.setReturned(true);
			}else if(dataPack.get("recordisreturned"+String.valueOf(i)).equals("false")){
				recordfromData.setReturned(false);
			}
			recordArr.add(recordfromData);
		}
		return recordArr;
	}
	
	private String calculateDueDate() throws CopyNotFoundException {
		String days = getItem().getHoldDays();
		Date date = new Date();
		long today = date.getTime();
		int iDays = Integer.parseInt(days);
		long lDueDate = today+iDays*DAYTIMELONG;
		String sDueDate = dateLongtoString(lDueDate);
		return sDueDate;
	}
	
	private String dateLongtoString(long dueTime) {
		Date dateTool = new Date();
		dateTool.setTime(dueTime);
		dateTool.getTime();
		DateFormat a = DateFormat.getDateInstance(DateFormat.SHORT);
		String dueString = a.format(dateTool);
		return dueString;
	}

	public void completeCheckOut() throws CopyNotFoundException {
		ParameterBox recordData = packRecordData();
		new DataModel().saveRecordtoData(recordData);
	}

	private ParameterBox packRecordData() throws CopyNotFoundException {
		ParameterBox dataPackage = new ParameterBox();
		dataPackage.add("recordid", getRecordId());
		dataPackage.add("recordcopyid", getItem().getCopyId());
		dataPackage.add("recorditemname", getItem().getTitle());
		dataPackage.add("recorditemduedate", getDueDate());
		dataPackage.add("recordpatronid", getPatron().getPatronId());
		if(isReturned()) {
			dataPackage.add("recordisreturned", "true");
		}else {
			dataPackage.add("recordisreturned", "false");
		}
		
		return dataPackage;
	}

	public void addPatron(Patron currentPatron) {
		setPatron(currentPatron);
		
	}
	
	
	public String getRecordId() {
		if(this.recordId == null)
		{
			return "";
		}
		return recordId;
	}

	private void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	private RentalLineItem getItem() throws CopyNotFoundException {
		if(item == null) {
			return new RentalLineItem("0");
		}
		return item;
	}

	private void setItem(RentalLineItem item) {
		this.item = item;
	}

	private Patron getPatron() {
		return patron;
	}

	private void setPatron(Patron patron) {
		this.patron = patron;
	}

	public String getDueDate() {
		return dueDate;
	}

	private void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}


	public boolean isReturned() {
		return isReturned;
	}

	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}

	
	
}
