package logic_layer;

import exceptions.CopyNotFoundException;

public class RentalLineItem {
	private Copy copy = null;
	private String itemName = "";

	RentalLineItem(String copyId) throws CopyNotFoundException {
		copy = new Copy().getCopybyId(copyId);
	}

	public String getTitle() {
		return this.copy.getTitle();
	}

	public String getHoldDays() {
		return this.copy.getHoldDays();
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
	
	public void setItemName(String name) {
		this.itemName = name;
	}

	public String getItemName() {
		return itemName;
	}

	public String getCopyId() {
		return getCopy().getCopyID();
	}

	public boolean isCopyAvailable() {
		return getCopy().isAvailable();
	}


	
}
