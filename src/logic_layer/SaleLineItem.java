package logic_layer;


import exceptions.CopyNotFoundException;

public class SaleLineItem {
	private Copy copy = null;
	
	SaleLineItem(String copyId) throws CopyNotFoundException{
		copy = new Copy().getCopybyId(copyId);
	}
	
	public String getTitle(){
		//make sure copy is not null
		return null;
		
	}
	
	public String getPrice(){
		//make sure copy is not null

		return null;
		
	}

	private Copy getCopy() {
		if(copy == null) {
			return new Copy();
		}
		return copy;
	}

	private void setCopy(Copy copy) {
		this.copy = copy;
	}

	public String getISBN() {
		
		return getCopy().getISBN();
	}

	public String getCopyId() {
		
		return getCopy().getCopyID();
	}

}
