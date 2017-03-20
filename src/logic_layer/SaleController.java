package logic_layer;

import exceptions.CopyNotFoundException;

public class SaleController {
	Patron ourPatron=new Patron();
	Copy ourCopy=new Copy();
	Payment ourPayment=new Payment();
	
	public void startSale(){// do we call the Order or Sale Line Item?
		
	}
	
	public void enterPatronId(String patronId){
		ourPatron.getPatronId();
	}
	
	public void enterCopyId(String copyId) throws CopyNotFoundException{
		ourCopy.getCopy(copyId);
	}
	
	public void makePayment(int amountPaid){
		ourPayment.makeThePayment(amountPaid);
	}
}
