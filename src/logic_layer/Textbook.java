package logic_layer;


import data_layer.DataModel;
import exceptions.TextbookNotFoundException;

public class Textbook {
	private String title = "";
	private String author = "";
	private String price = "";
	private String isbn = "";
	private String holdDays = "";

	
	public Textbook getTextbookbyISBN(String isbn) throws TextbookNotFoundException{
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
			this.holdDays = dataPack.get("textbookholddays");
		}
		
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	private void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	private void setPrice(String price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	private void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getHoldDays() {
		return holdDays;
	}

	private void setHoldDays(String holdDays) {
		this.holdDays = holdDays;
	}

	private void setTitle(String title) {
		this.title = title;
	}

}


