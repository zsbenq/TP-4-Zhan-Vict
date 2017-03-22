package logic_layer;


import data_layer.DataModel;
import exceptions.PatronNotFoundException;

public class Patron {
	private String patronId = "";
	private String patronName = "";
	
	public Patron getPatron(String id) throws PatronNotFoundException {
		this.patronId = id;
		getPatronfromData(this.patronId);
		return this;
	}
	
	private void getPatronfromData(String id) throws PatronNotFoundException {
		ParameterBox dataPack = new DataModel().getPatronbyId(id);
		unpackPatronData(dataPack);
	}

	private void unpackPatronData(ParameterBox dataPack) throws PatronNotFoundException {
		if(dataPack.isEmpty()){
			throw new PatronNotFoundException("patron id: " + this.patronId + " is not found");
		}else{
			this.patronId = dataPack.get("patronid");
			this.patronName = dataPack.get("patronname");
		}
		
	}

	public String getPatronId() {
		return patronId;
	}
	public String getPatronName() {
		return patronName;
	}
	
	

}
