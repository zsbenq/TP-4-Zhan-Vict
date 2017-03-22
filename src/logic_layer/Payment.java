package logic_layer;


import java.util.Date;

import exceptions.PaymentFailException;

public class Payment {
	private String method = "";
	private String payDate = "";
	public void makePayment(String paymentMethod) throws PaymentFailException {
		
		//don't implement this function, it always succeed
		boolean isPaySuccess = true;
		this.method = paymentMethod;
		Date date = new Date();
		long today = date.getTime();
		this.payDate = String.valueOf(today);
		if(!isPaySuccess){
			throw new PaymentFailException();
		}
		

	}
	public String getMethod() {
		return method;
	}
	public String getPayDate() {
		return payDate;
	}
}
