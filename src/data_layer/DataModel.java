package data_layer;

import java.util.Map;


import logic_layer.ParameterBox;

public class DataModel {

	public ParameterBox getCopybyId(String copyId) {
		// TODO Auto-generated method stub
		return null;
	}

	public ParameterBox getTextbookbyISBN(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveOrdertoDate(ParameterBox orderData) {
		
	}

	public ParameterBox getPatronbyId(String patronId) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNewOrderNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveRecordtoData(ParameterBox recordData) {
		// TODO Auto-generated method stub
		
	}

	public String getNewRecordId() {
		// TODO Auto-generated method stub
		return null;
	}

	public ParameterBox getAllRentalRecordsbyPatronId() {
		return null;
		// TODO Auto-generated method stub
		
	}

	public String getUnreturnedRecordIdbyCopyId(String copyId) {
		return copyId;
		// TODO Auto-generated method stub
		
	}

	public void updateRecordIsReturnedValue(String recordId, boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void updateCopyInStock(String copyID, boolean b) {
		// TODO Auto-generated method stub
		
	}
}
