
public class Process {
	private static int arrivalTime, CPUTime, reqMem;
	
	public Process(int PID, int priority, PIDList PIDs, int memoryNeeded){
		reqMem = memoryNeeded;
		ProcessControlBlock PCB = new ProcessControlBlock(this, PID, priority, PIDs);
		Scheduler.insertPCB(PCB);
		allocateRAM();
	}

	public Process(PIDList PIDs){
		ProcessControlBlock PCB = new ProcessControlBlock(this, PIDs);
		Scheduler.insertPCB(PCB);
	}

	public void allocateRAM(){
		//int temp
	}
	
}