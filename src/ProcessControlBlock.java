
//just look here https://en.wikipedia.org/wiki/Process_control_block
public class ProcessControlBlock {
	private int PID;
	private Process process;
	private State state;
	int priority, defaultPriority = 5;
	
	// Constructor with PID
	public ProcessControlBlock(int PID){
		this.PID = PID;
		
		// Create a new process
		this.process = new Process(PID);		
		this.priority = defaultPriority;
		this.state = State.NEW;
	}
	
	// Constructor with process provided
	public ProcessControlBlock(Process p){
		this.PID = p.getPID();
		this.process = p;
		this.priority = defaultPriority;
		this.state = State.NEW;
	}
	
	public Process getProcess(){
		return process;
	}
	
	public int getPriority(){
		return priority;
	}
	
	public ProcessControlBlock setPriority(int p){
		this.priority = p;
		return this;
	}
	
	public int getPID(){
		return PID;
	}
	
	public State getState(){
		return state;
	}
	
	public ProcessControlBlock setState(State state){
		this.state = state;
		return this;
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

