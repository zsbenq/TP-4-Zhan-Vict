package logic_layer;


import exceptions.CopyNotFoundException;

public class SaleLineItem {
	private Copy copy = null;
	private Textbook textbook;
	
	SaleLineItem(String copyId) throws CopyNotFoundException{
		copy = new Copy().getCopy(copyId);
	}
	
	public String getTitle(){
		return null;
		
	}
	
	public String getPrice(){
		return null;
		
	}

}
