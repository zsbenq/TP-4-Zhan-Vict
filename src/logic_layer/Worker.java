package logic_layer;

public class Worker {
	private String workID = "";
	private String name = "";
	private static Worker currentWorker = new Worker();
	public String getWorkID() {
		return workID;
	}
	public void setWorkID(String workID) {
		this.workID = workID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void startWork() {
		currentWorker = this;
	}
	
	Worker whoisWorking(){
		return currentWorker;
	}
}
