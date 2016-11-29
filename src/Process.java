public class Process {
	private int PID, arrivalTime, CPUTime, reqMem;
	
	public Process(){
		this.PID = PIDGenerator.newPID();
	}
	
	public Process(int PID){
		this.PID = PID;
	}
	
	public int getPID(){
		return this.PID;
	}
}