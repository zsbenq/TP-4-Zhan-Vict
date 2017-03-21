package logic_layer;

import data_layer.DataModel;
import exceptions.CopyNotFoundException;
import exceptions.TextbookNotFoundException;

public class Copy {
	private String copyID = "";
	private String condition = "";
	private String isbn = "";
	private Textbook textbook = new Textbook();
	
	public Copy getCopy(String id) throws CopyNotFoundException{
		try{
			this.copyID = id;
			getCopyfromData(this.copyID);
			getTextbook(this.isbn);
		}catch(CopyNotFoundException e){
			throw new CopyNotFoundException();
		}
		
		return this;
	}

	private void getTextbook(String isbn) throws CopyNotFoundException {
		try{
			Textbook textbook = new Textbook().getTextbook(isbn);
			this.textbook = textbook;
		}catch(TextbookNotFoundException e){
			throw new CopyNotFoundException();
		}
		
	}

	private void getCopyfromData(String id) throws CopyNotFoundException{
		ParameterBox dataPack = new DataModel().getCopybyId(id);
		try{
			unpackCopyData(dataPack);
		}catch(CopyNotFoundException e){
			throw new CopyNotFoundException();
		}
		
	}

	private void unpackCopyData(ParameterBox dataPack) throws CopyNotFoundException{
		if(dataPack.isEmpty()){
			throw new CopyNotFoundException("copyID: " + this.copyID + " is not found");
		}
		if(this.isbn.isEmpty()){
			throw new CopyNotFoundException("ISBN: " + this.isbn + "is not found");
		}
		this.isbn = dataPack.get("ISBN");
		this.condition = dataPack.get("condition");
	}

	
}


