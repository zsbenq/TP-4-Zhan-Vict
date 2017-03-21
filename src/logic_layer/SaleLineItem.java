package logic_layer;


import exceptions.CopyNotFoundException;

public class SaleLineItem {
	private Copy copy = null;
	
	SaleLineItem(String copyId) throws CopyNotFoundException{
		copy = new Copy().getCopy(copyId);
	}
	
	public String getTitle(){
		//make sure copy is not null
		return null;
		
	}
	
	public String getPrice(){
		//make sure copy is not null

		return null;
		
	}

}
