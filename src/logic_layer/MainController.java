package logic_layer;


import data_layer.FakeDatabase;
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
		actionDispatcher.bindmainControllerInterface(mainController);
		PageGenerator pageGenerator = new PageGenerator(actionDispatcher);
		mainController.setPageGenerator(pageGenerator);
		mainController.setRentalController(rentalController);
		mainController.setSaleController(saleController);
		Worker worker = new Worker();
		worker.setName("Tom");
		worker.setWorkID("000001");
		worker.startWork();
		new FakeDatabase();
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
			if(getCurrentProcess() == RENTALPROCESS){
				beginRentalProcessWithPatronId(inputPatronId);
				
			}else if(getCurrentProcess() == SALEPROCESS){
				beginSaleProcessWithPatronId(inputPatronId);
			}
			pageGenerator.getCopyIDfromUserInput();
		}catch(PatronNotFoundException e){
			pageGenerator.displayPatronIdError();
		} catch (CopyNotFoundException e) {
			
		}
	}

	public void beginRentalProcessWithPatronId(String inputPatronId) throws PatronNotFoundException, CopyNotFoundException
	{
		ParameterBox patronInfoPack = rentalController.enterPartonId(inputPatronId);
		pageGenerator.displayPatronInfo(patronInfoPack);
		ParameterBox patronRecordsPack = rentalController.getPatronAllRentalRecords(inputPatronId);
		pageGenerator.displayPatronRecords(patronRecordsPack);
	}
	
	public void beginSaleProcessWithPatronId(String inputPatronId) throws PatronNotFoundException
	{
		ParameterBox pack = new ParameterBox();
		pack = saleController.enterPartonId(inputPatronId);
		pageGenerator.displayPatronInfo(pack);
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
		if(getCurrentProcess() == RENTALPROCESS){
			sendCopyIdtoRentalController(inputString);
		}else if(getCurrentProcess() == SALEPROCESS){
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
		setCurrentProcess(0);
	}


	@Override
	public void startCheckIn() {
		setCurrentProcess(RENTALPROCESS);
		rentalController.startCheckIn();
		pageGenerator.getCopyIDfromUserInput();
	}



	@Override
	public void startCheckOut() {
		setCurrentProcess(RENTALPROCESS);
		rentalController.startCheckOut();
		pageGenerator.getPatronIDfromUserInput();
	}



	@Override
	public void startSale() {
		setCurrentProcess(SALEPROCESS);
		saleController.startSale();
		pageGenerator.getPatronIDfromUserInput();
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
	
	private void setCurrentProcess(int process){
		this.currentProcess = process;
	}
	
	private int getCurrentProcess(){
		return this.currentProcess;
	}

	@Override
	public void CheckPatronRecord() {
		// TODO Auto-generated method stub
		
	}
}
