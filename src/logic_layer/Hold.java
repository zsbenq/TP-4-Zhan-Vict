package logic_layer;
import java.text.DateFormat;
import java.util.Date;
import java.*;

public class Hold {
	private String holdId = "";
	private String status = "";
	private Copy holdingCopy = null;
	private String today;
	private boolean isDamaged;
	
	Patron patron=new Patron();
	RentalRecord newRecord=new RentalRecord();
	
	
	public void getHoldPatronID(){
		patron.getPatronId();
	}
	
	public boolean isDamaged(){
		return isDamaged;
	}
	
	public void setDamaged(boolean isDamaged) {
		this.isDamaged=isDamaged();
	}
	
	public String isOverdue(){
		if(!newRecord.isReturned());
		return holdId;
	}
	
	
	public void setOverdue(){
		String dueDate=this.newRecord.getDueDate();
		
	}
}
