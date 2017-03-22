package logic_layer;


import exceptions.CopyNotFoundException;

public class SaleLineItem {
	private Copy copy = null;
	private Order order;
	
	SaleLineItem(String copyId) throws CopyNotFoundException{
		copy = new Copy().getCopybyId(copyId);
	}
	
	public String getTitle(){
		//where are we implementing title? I have not seen it yet.
		return null;
		
	}
	
	public String getPrice(){
		return this.order.getItemPrice();
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
