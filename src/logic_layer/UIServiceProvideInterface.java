package logic_layer;

import java.util.Map;

public interface UIServiceProvideInterface {
	public void getPatronIDfromUserInput();
	public void displayPatronInfo(Map<String, String> parameterPackage);
	public void getCopyIDfromUserInput();
	public void displaySaleItem(Map<String, String> parameterPackage);
	public void displayReceipt(Map<String, String> parameterPackage);
}
