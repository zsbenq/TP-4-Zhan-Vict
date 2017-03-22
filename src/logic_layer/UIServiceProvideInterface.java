package logic_layer;


public interface UIServiceProvideInterface {
	public void getPatronIDfromUserInput();

	public void displayPatronInfo(ParameterBox param);
	public void getCopyIDfromUserInput();
	public void displaySaleCopy(ParameterBox param);
	public void displayReceipt(ParameterBox param);
	public void displayPatronIdError();
	public void displayCopyIdError();
	public void displayPaymentMethod();
	public void displayPaymentFail();
	public void displayCheckOutInfo(ParameterBox param);

	public void displayCheckOutComplete();

	public void displayCheckInComplete();

}
