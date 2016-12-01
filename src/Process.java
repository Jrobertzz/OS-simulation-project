public class Process {
	private int PID, arrivalTime, CPUTime, reqMem;
	
	public Process(int reqMem){
		this.PID = PIDGenerator.newPID();		
		this.reqMem = reqMem;
	}
	
	public int getPID(){
		return this.PID;
	}
	
	public int getRequiredMemory(){
		return reqMem;
	}
	
	public Process setRequiredMemory(int reqMem){
		this.reqMem = reqMem;
		return this;
	}
	
	
}