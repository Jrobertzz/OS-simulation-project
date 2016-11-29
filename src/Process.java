
public class Process {
	private int arrivalTime, CPUTime;
	
	public Process(int PID, int priority, PIDList PIDs){
		ProcessControlBlock PCB = new ProcessControlBlock(this, PID, priority, PIDs);
		Scheduler.insertPCB(PCB);
	}

	public Process(PIDList PIDs){
		ProcessControlBlock PCB = new ProcessControlBlock(this, PIDs);
		Scheduler.insertPCB(PCB);
	}

	
	
}