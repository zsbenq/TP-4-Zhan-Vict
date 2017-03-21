package logic_layer;


import exceptions.PaymentFailException;

public class Payment {
	public void makePayment() throws PaymentFailException {
		
		//don't implement this function, it always succeed
		boolean isPaySuccess = true;
		if(!isPaySuccess){
			throw new PaymentFailException();
		}
		

	}
}
