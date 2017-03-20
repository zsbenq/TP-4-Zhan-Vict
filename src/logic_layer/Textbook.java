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
		try{
			this.isbn = isbn;
			getTextbookfromData(this.isbn);
		}catch(TextbookNotFoundException e){
			throw new TextbookNotFoundException();
		}
		
		return this;
	}
	private void getTextbookfromData(String isbn) throws TextbookNotFoundException{
		Map<String, String> dataPack = new DataModel().getTextbookbyISBN(isbn);
		try{
			unpackTextbookData(dataPack);
		}catch(TextbookNotFoundException e){
			throw new TextbookNotFoundException();
		}
		
	}
	private void unpackTextbookData(Map<String, String> dataPack) throws TextbookNotFoundException{
		this.title = dataPack.get("title");
		this.author = dataPack.get("author");
		this.price = dataPack.get("price");
		
		if(dataPack.isEmpty()){
			throw new TextbookNotFoundException("ISBN: "+ this.isbn + " is not found");
		}
	}

}


