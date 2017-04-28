package data_layer;


import java.util.HashMap;
import java.util.Map;

import logic_layer.ParameterBox;

public class DataModel {
	
	public ParameterBox getCopybyId(String copyId) {
		ParameterBox box = new ParameterBox();
		for(int i=0; i<FakeDatabase.COPY.size(); i++){
			if(FakeDatabase.COPY.get(i).get("copyid").equals(copyId)){
				box.add("copyid", FakeDatabase.COPY.get(i).get("copyid"));
				box.add("copyisbn", FakeDatabase.COPY.get(i).get("isbn"));
				box.add("copycondition", FakeDatabase.COPY.get(i).get("condition"));
				box.add("copyinstock", FakeDatabase.COPY.get(i).get("instock"));
				break;
			}
		}
		
		return box;
	}

	public static ParameterBox getTextbookbyISBN(String isbn) {
		ParameterBox box = new ParameterBox();
		for(int i=0; i<FakeDatabase.TEXTBOOK.size(); i++){
			if(FakeDatabase.TEXTBOOK.get(i).get("isbn").equals(isbn)){
				box.add("textbooktitle", FakeDatabase.TEXTBOOK.get(i).get("title"));
				box.add("textbookauthor", FakeDatabase.TEXTBOOK.get(i).get("author"));
				box.add("textbookprice", FakeDatabase.TEXTBOOK.get(i).get("price"));
				box.add("textbookholddays", FakeDatabase.TEXTBOOK.get(i).get("holddays"));
				box.add("textbookisbn", FakeDatabase.TEXTBOOK.get(i).get("isbn"));
				break;
			}
		}
		return box;
	}

	public void saveOrdertoDate(ParameterBox orderData) {
		Map<String, String> newOrder = unpackOrderData(orderData);
		FakeDatabase.ORDER.add(newOrder);
	}
	
	private Map<String, String> unpackOrderData(ParameterBox orderData) {
		Map<String, String> order = new HashMap<String, String>();
		order.put("orderid", orderData.get("ordernumber"));
		order.put("isbn", orderData.get("orderisbn"));
		order.put("copyid", orderData.get("ordercopyid"));
		order.put("price", orderData.get("orderprice"));
		order.put("paydate", orderData.get("orderpaydate"));
		order.put("paymentmethod", orderData.get("orderpaymentmethod"));
		return order;
	}

	public ParameterBox getPatronbyId(String patronId) {
		ParameterBox box = new ParameterBox();
		for(int i=0; i<FakeDatabase.PATRON.size(); i++){
			if(FakeDatabase.PATRON.get(i).get("patronid").equals(patronId)){
				box.add("patronid", FakeDatabase.PATRON.get(i).get("patronid"));
				box.add("patronname", FakeDatabase.PATRON.get(i).get("name"));
				break;
			}
		}
		return box;
	}

	public String getNewOrderNumber() {
		int orderSize = FakeDatabase.ORDER.size();
		String newOrderNumber = "1";
		if(orderSize > 0) {
			String lastOrderNumber = FakeDatabase.ORDER.get(orderSize-1).get("orderid");
			newOrderNumber = String.valueOf(Integer.parseInt(lastOrderNumber) + 1);
		}
		return newOrderNumber;
	}

	public void saveRecordtoData(ParameterBox recordData) {
		Map<String, String> newRecord = unpackRecordData(recordData);
		FakeDatabase.RECORD.add(newRecord);
		
	}

	private Map<String, String> unpackRecordData(ParameterBox recordData) {
		Map<String, String> record = new HashMap<String, String>();
		record.put("recordid", recordData.get("recordid"));
		record.put("copyid", recordData.get("recordcopyid"));
		record.put("title", recordData.get("recorditemname"));
		record.put("duedate", recordData.get("recorditemduedate"));
		record.put("patronid", recordData.get("recordpatronid"));
		record.put("isreturned", recordData.get("recordisreturned"));
		return record;
	}

	public String getNewRecordId() {
		int recordSize = FakeDatabase.RECORD.size();
		String newRecordNumber = "1";
		if(recordSize > 0) {
			String lastRecordNumber = FakeDatabase.RECORD.get(recordSize-1).get("recordid");
			newRecordNumber = String.valueOf(Integer.parseInt(lastRecordNumber) + 1);
		}
		return newRecordNumber;
	}

	public ParameterBox getAllRentalRecordsbyPatronId(String patronId) {
		ParameterBox box = new ParameterBox();
		int recordSize = FakeDatabase.RECORD.size();
		box.add("size", String.valueOf(recordSize));
		int count = 0;
		for(int i=0; i<recordSize; i++){
			if(FakeDatabase.RECORD.get(i).get("patronid").equals(patronId)){
				box.add("recordid"+String.valueOf(count), FakeDatabase.RECORD.get(i).get("recordid"));
				box.add("recorditemname"+String.valueOf(count), FakeDatabase.RECORD.get(i).get("title"));
				box.add("recorditemduedate"+String.valueOf(count), FakeDatabase.RECORD.get(i).get("duedate"));
				box.add("recordisreturned"+String.valueOf(count), FakeDatabase.RECORD.get(i).get("isreturned"));
				count++;
			}
		}
		return box;
		
	}

	public String getUnreturnedRecordIdbyCopyId(String copyId) {
		String targetRecordId = "0";
		for(int i=0; i<FakeDatabase.RECORD.size(); i++){
			if(FakeDatabase.RECORD.get(i).get("copyid").equals(copyId)){
				targetRecordId = FakeDatabase.RECORD.get(i).get("recordid");
				break;
			}
		}
		return targetRecordId;
	}

	public void updateRecordIsReturnedValue(String recordId, boolean b) {
		for(int i=0; i<FakeDatabase.RECORD.size(); i++){
			if(FakeDatabase.RECORD.get(i).get("recordid").equals(recordId)){
				if(b == true){
					FakeDatabase.RECORD.get(i).put("isreturned", "true");
				}else{
					FakeDatabase.RECORD.get(i).put("isreturned", "false");
				}
				
				break;
			}
		}
		
	}

	public void updateCopyInStock(String copyID, boolean b) {
		for(int i=0; i<FakeDatabase.COPY.size(); i++){
			if(FakeDatabase.COPY.get(i).get("copyid").equals(copyID)){
				if(b == true){
					FakeDatabase.COPY.get(i).put("instock", "true");
				}else{
					FakeDatabase.COPY.get(i).put("instock", "false");
				}
				
				break;
			}
		}
		
	}

}
