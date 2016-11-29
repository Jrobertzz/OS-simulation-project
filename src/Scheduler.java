import java.util.Comparator;

/*
 * Simple Scheduler, ideally broken up into
 * short term and long term schedulers
 * 
 * created be Jrobertzz
 */
public class Scheduler{
	private Comparator<ProcessControlBlock> comparator = new PriorityComparator();
	private ExecutionQueue waiting;
	private ExecutionQueue ready;

	public Scheduler(){
		waiting = new ExecutionQueue(comparator);
		ready = new ExecutionQueue(comparator);
	}
	
	public void handleState(ProcessControlBlock pcb){
		
		// If PCB state is terminated, remove the process from the queue
		if (pcb.getState() == State.EXIT){
			removePCB(pcb.getPID());
		}
	}
	
	
	public void insertPCB(Process p, int priority){
		// If ram is available, add to ready queue
		ProcessControlBlock pcb = new ProcessControlBlock(p).setPriority(priority);
		ready.enQueue(pcb);
		pcb.setState(State.READY);
		
		// Else add to waiting queue
		// waiting.enQueue(pcb);
		// pcb.setState(State.WAIT);
	}
	
	public void removePCB(int PID){
		ready.deQueue(PID);
	}
	
	public ExecutionQueue getReadyQueue(){
		return ready;
	}
	
	public ExecutionQueue getWaitingQueue(){
		return waiting;
	}


	

}