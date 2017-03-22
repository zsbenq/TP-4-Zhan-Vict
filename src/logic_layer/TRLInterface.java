package logic_layer;

public interface TRLInterface {
	public void EnterPatronId(String inputPatronId);

	public void EnterCopyId(String inputString);

	public void startCheckIn();

	public void startCheckOut();

	public void startSale();

	public void CheckPatronRecord();

	public void paymentMethod(String string);

	public void confirmCheckOut();
}
