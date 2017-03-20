package logic_layer;

public class Payment {
	private String typeOfPayment;
	private int amountPaid;
	
	public void paymentType(String typeOfPayment){
	this.typeOfPayment=typeOfPayment;
	}
	
	public void makeThePayment(int amountPaid) {
		this.amountPaid=amountPaid;
		if(amountPaid <=0){
			System.out.println("Error. Payment must be greater than $0.");
		}
	}
}
