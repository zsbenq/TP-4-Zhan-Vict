package logic_layer;


import exceptions.CopyNotFoundException;
import exceptions.PatronNotFoundException;
import exceptions.PaymentFailException;
import ui_layer.ActionDispatcher;
import ui_layer.PageGenerator;

public class MainController implements TRLInterface{
	private PageGenerator pageGenerator = null;
	private SaleController saleController = null;
	private RentalController rentalController = null;
	private int currentProcess = 0;
	private static final int RENTALPROCESS = 1;
	private static final int SALEPROCESS = 2;
	
	public static void main(String[] args) {
		
		MainController app = initialization();
		run(app);
	}

	private static MainController initialization() {
		MainController mainController = new MainController();
		SaleController saleController = new SaleController();
		RentalController rentalController = new RentalController();
		ActionDispatcher actionDispatcher = new ActionDispatcher();
		actionDispatcher.bindSystemInterface(mainController);
		PageGenerator pageGenerator = new PageGenerator(actionDispatcher);
		mainController.setPageGenerator(pageGenerator);
		mainController.setRentalController(rentalController);
		mainController.setSaleController(saleController);
		return mainController;
	}


	private static void run(MainController controller) {
		while(true){
			controller.showMainPage();
		}
	}

	private void showMainPage() {
		pageGenerator.displayMainMenu();
	}
	
	@Override
	public void EnterPatronId(String inputPatronId) {
		try{
			ParameterBox responsePack = sendPatronIdtoController(inputPatronId);
			pageGenerator.displayPatronInfo(responsePack);
			pageGenerator.getCopyIDfromUserInput();
		}catch(PatronNotFoundException e){
			pageGenerator.displayPatronIdError();
		}
	}

	private ParameterBox sendPatronIdtoController(String inputPatronId) throws PatronNotFoundException {
		ParameterBox pack = new ParameterBox();
		if(currentProcess == RENTALPROCESS){
			pack = rentalController.enterPartonId(inputPatronId);
		}else if(currentProcess == SALEPROCESS){
			pack = saleController.enterPartonId(inputPatronId);
		}
		return pack;
	}

	@Override
	public void EnterCopyId(String inputString) {
		try {
			sendCopyIdtoController(inputString);
		}catch(CopyNotFoundException e) {
			pageGenerator.displayCopyIdError();
		}
	}

	private void sendCopyIdtoController(String inputString) throws CopyNotFoundException {
		if(currentProcess == RENTALPROCESS){
			sendCopyIdtoRentalController(inputString);
		}else if(currentProcess == SALEPROCESS){
			sendCopyIdtoSaleController(inputString);
		}
	}

	private void sendCopyIdtoSaleController(String inputString) throws CopyNotFoundException {
		ParameterBox responsePack = saleController.enterCopyId(inputString);
		pageGenerator.displaySaleCopy(responsePack);
		pageGenerator.displayPaymentMethod();
	}

	private void sendCopyIdtoRentalController(String inputString) throws CopyNotFoundException {
		ParameterBox responsePack = rentalController.enterCopyId(inputString);
		if(responsePack.get("complete") == null){
			pageGenerator.displayCheckOutInfo(responsePack);
		}else{
			pageGenerator.displayCheckInComplete(responsePack);
		}
	}

	@Override
	public void confirmCheckOut() {
		try{
			rentalController.completeCheckOut();
			pageGenerator.displayCheckOutComplete();
			finishProcess();
		}catch(CopyNotFoundException e){
			pageGenerator.displayCopyIdError();
		}
	}
	
	private void finishProcess() {
		currentProcess = 0;
	}


	@Override
	public void startCheckIn() {
		currentProcess = RENTALPROCESS;
		rentalController.startCheckIn();
		pageGenerator.getCopyIDfromUserInput();
	}



	@Override
	public void startCheckOut() {
		currentProcess = RENTALPROCESS;
		rentalController.startCheckOut();
		pageGenerator.getPatronIDfromUserInput();
	}



	@Override
	public void startSale() {
		currentProcess = SALEPROCESS;
		saleController.startSale();
		pageGenerator.getPatronIDfromUserInput();
	}

	

	@Override
	public void CheckPatronRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paymentMethod(String method) {
		try{
			ParameterBox responsePack = saleController.makePayment(method);
			pageGenerator.displayReceipt(responsePack);
			finishProcess();
		}catch(PaymentFailException e){
			pageGenerator.displayPaymentFail();
		}
		
	}

	private void setPageGenerator(PageGenerator pageGenerator) {
		this.pageGenerator = pageGenerator;
	}

	private void setSaleController(SaleController saleController) {
		this.saleController = saleController;
	}

	private void setRentalController(RentalController rentalController) {
		this.rentalController = rentalController;
	}

}
