package logic_layer;

import java.util.Map;

public interface UIServiceProvideInterface {
	public void getPatronIDfromUserInput();
	public void displayPatronInfo(ParameterBox param);
	public void getCopyIDfromUserInput();
	public void displaySaleCopy(ParameterBox param);
	public void displayReceipt(ParameterBox param);
	public void displayPatronIdError();
	public void displayCopyIdError();
}
