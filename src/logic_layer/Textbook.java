package logic_layer;

import java.util.Map;

import data_layer.DataModel;
import exceptions.TextbookNotFoundException;

public class Textbook {
	private String title = "";
	private String author = "";
	private String price = "";
	private String isbn = "";
	
	public Textbook getTextbook(String isbn) throws TextbookNotFoundException{
		this.isbn = isbn;
		getTextbookfromData(this.isbn);
		return this;
	}
	
	private void getTextbookfromData(String isbn) throws TextbookNotFoundException{
		ParameterBox dataPack = new DataModel().getTextbookbyISBN(isbn);
		unpackTextbookData(dataPack);
	}
	
	private void unpackTextbookData(ParameterBox dataPack) throws TextbookNotFoundException{
		if(dataPack.isEmpty()){
			throw new TextbookNotFoundException("ISBN: "+ this.isbn + " is not found");
		}else{
			this.title = dataPack.get("textbooktitle");
			this.author = dataPack.get("textbookauthor");
			this.price = dataPack.get("textbookprice");
		}
		
		
		
	}

}


