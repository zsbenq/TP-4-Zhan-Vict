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
		}catch(TextbookNotFoundException e){
			throw new CopyNotFoundException();
		}
		
		return this;
	}

	private void getTextbook(String isbn) throws TextbookNotFoundException  {
			Textbook textbook = new Textbook().getTextbook(isbn);
			this.textbook = textbook;
	}

	private void getCopyfromData(String id) throws CopyNotFoundException{
		ParameterBox dataPack = new DataModel().getCopybyId(id);
		unpackCopyData(dataPack);
	}

	private void unpackCopyData(ParameterBox dataPack) throws CopyNotFoundException{
		if(dataPack.isEmpty()){
			throw new CopyNotFoundException("copyID: " + this.copyID + " is not found");
		}else if(this.isbn.isEmpty()){
			throw new CopyNotFoundException("ISBN: " + this.isbn + "is not found");
		}else {
			this.isbn = dataPack.get("copyisbn");
			this.condition = dataPack.get("copycondition");
		}
		
	}

	public String getCondition() {
		return condition;
	}



	
}


