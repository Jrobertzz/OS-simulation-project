import java.util.ArrayList;

/*
 * Simple Scheduler, ideally broken up into
 * short term and long term schedulers
 * 
 * created be Jrobertzz
 */
public class Scheduler{
	static ExecutionQueue<ProcessControlBlock> waiting;
	static ExecutionQueue<ProcessControlBlock> ready;

	public Scheduler(){
		waiting = new ExecutionQueue<ProcessControlBlock>();
		ready = new ExecutionQueue<ProcessControlBlock>();
	}
	
	public static void add(int PID, int priority){
		
	}

	public static void remove(int PID){
		
	}
	
	public static void insertPCB(ProcessControlBlock pcb){
		// if ram is available, add to ready queue+
		if (ready.enQueue(pcb)){
			pcb.setState(State.READY);
		}
		
		
		// else add to waiting queue
		// if (waiting.enQueue(pcb)){
		//	 pcb.setState(State.WAIT);
	}
	
	public static void removePCB(ProcessControlBlock pcb){
		//ready.deQueue(pcb);
		//waiting.deQueue(pcb);
	}

	

}
