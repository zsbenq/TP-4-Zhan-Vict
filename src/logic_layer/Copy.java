package logic_layer;


import data_layer.DataModel;
import exceptions.CopyNotFoundException;
import exceptions.TextbookNotFoundException;

public class Copy {
	private String copyID = "";
	private String condition = "";
	private String isbn = "";
	private Textbook textbook = null;
	private boolean inStock = false;
	
	public Copy getCopybyId(String id) throws CopyNotFoundException{
		try{
			setCopyID(id);
			getCopyfromData(id);
			getTextbookbyISBN(getIsbn());
		}catch(TextbookNotFoundException e){
			throw new CopyNotFoundException();
		}
		
		return this;
	}

	private void getTextbookbyISBN(String isbn) throws TextbookNotFoundException  {
			Textbook textbook = new Textbook().getTextbookbyISBN(isbn);
			setTextbook(textbook);
	}

	private void getCopyfromData(String id) throws CopyNotFoundException{
		ParameterBox dataPack = new DataModel().getCopybyId(id);
		unpackCopyData(dataPack);
	}

	private void unpackCopyData(ParameterBox dataPack) throws CopyNotFoundException{
		if(dataPack.isEmpty()){
			throw new CopyNotFoundException("copyID: " + getCopyID() + " is not found");
		}else {
			setIsbn(dataPack.get("copyisbn"));
			setCondition(dataPack.get("copycondition"));
			if(dataPack.get("copyinstock").equals("true")) {
				setInStock(true);
			}else{
				setInStock(false);
			}
			
		}
		
	}

	public String getCondition() {
		return condition;
	}
	
	public String getHoldDays() {
		String holddays = getTextbook().getHoldDays();
		return holddays;
	}
	
	public String getTitle() {
		String title = getTextbook().getTitle();
		return title;
	}

	public String getCopyID() {
		return copyID;
	}

	private void setCopyID(String copyID) {
		this.copyID = copyID;
	}

	private String getIsbn() {
		return isbn;
	}

	private void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	private Textbook getTextbook() {
		if(textbook == null)
		{
			return new Textbook();
		}
		return textbook;
	}

	private void setTextbook(Textbook textbook) {
		this.textbook = textbook;
	}

	private void setCondition(String condition) {
		this.condition = condition;
	}

	public boolean getInStock() {
		return inStock;
	}

	private void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public void goInStock() {
		new DataModel().updateCopyInStock(getCopyID(), true);
	}

	public void goOutStock() {
		new DataModel().updateCopyInStock(getCopyID(), false);
		
	}

	

	
}


