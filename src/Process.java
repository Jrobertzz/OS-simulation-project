
public class Process {
	public Process(int PID, int priority, PIDList PIDs){
		//Scheduler.add(PID, priority);
	}
	public Process(PIDList PIDs){
		ProcessControlBlock PCB = new ProcessControlBlock(this, PIDs);
	}
	
}