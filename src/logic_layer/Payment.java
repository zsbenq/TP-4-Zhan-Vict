package logic_layer;


import java.text.DateFormat;
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
		this.payDate = dateLongtoString(today);
		if(!isPaySuccess){
			throw new PaymentFailException();
		}
		

	}
	
	private String dateLongtoString(long dueTime) {
		Date dateTool = new Date();
		dateTool.setTime(dueTime);
		dateTool.getTime();
		DateFormat a = DateFormat.getDateInstance(DateFormat.SHORT);
		String dueString = a.format(dateTool);
		return dueString;
	}
	
	public String getMethod() {
		return method;
	}
	public String getPayDate() {
		return payDate;
	}
}
