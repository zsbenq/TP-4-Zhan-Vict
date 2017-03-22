package logic_layer;
import java.text.DateFormat;
import java.util.Date;
import java.*;

public class Hold {
	private String holdId = "";
	private String status = "";
	private Copy holdingCopy = null;
	private boolean isDamaged;
	
	Patron patron=new Patron();
	RentalRecord newRecord=new RentalRecord();

	public String getHoldPatronID(){
		return patron.getPatronId();
	}
	
	public String getCondition(){
		return this.holdingCopy.getCondition();
	}
	
	public String isOverdue(){
		if(!newRecord.isReturned());
		return holdId;
	}
	
	public void setOverdue(){
		String dueDate=this.newRecord.getDueDate();
		
	}
}
