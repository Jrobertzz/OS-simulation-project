
//just look here https://en.wikipedia.org/wiki/Process_control_block
public class ProcessControlBlock {
	int PID;
	State state;
	int priority, defaultPriority = 5;
	
	// Constructor with no PID or priority provided
	public ProcessControlBlock(Process p, PIDList PIDs){
		PID = generatePID(PIDs);
		priority = defaultPriority;
		state = State.NEW;
	}
	
	// Constructor with PID and priority provided
	public ProcessControlBlock(Process p, int PID, int priority, PIDList PIDs){
		this.PID = PID;
		this.priority = priority;
		state = State.NEW;
	}
	
	// Generate a random, unique PID
	private int generatePID(PIDList PIDs){
		int k = 0;
		int value = 0;
		// Generate random id for the process
		while(k==0){
			value = (int)(Math.random()*100);
			if(!PIDs.PIDExists(value)){
				k = 1;
			}
		}
		return value;
	}
	
	public int getPriority(){
		return priority;
	}
	
	public int getPID(){
		return PID;
	}
	
	public State getState(){
		return state;
	}
	
	public void setState(State state){
		this.state = state;
	}
	
	//TODO
	public void getWait(){}
	
	//TODO
	public void setWait(){}
	
	//TODO
	public void getArrival(){}
	
	//TODO
	public void setArrival(){}
	
	//TODO
	public void getCPUTime(){}
	
	//TODO
	public void setCPUTime(){}

}
