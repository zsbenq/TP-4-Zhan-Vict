package logic_layer;

public class Payment {
	public void makePayment() throws PaymentFailException {
		
		//don't implement this function, it always succeed
		boolean isPaySuccess = true;
		if(!isPaySuccess){
			throw new PaymentFailException();
		}
		
	}
}
