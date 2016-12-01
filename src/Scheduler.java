import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*
 * Simple Scheduler, ideally broken up into
 * short term and long term schedulers
 * 
 * created be Jrobertzz
 */
public class Scheduler{
	private ExecutionQueue ready;
	private List<ProcessControlBlock> waiting;
	
	private int quantum = 20;

	public Scheduler(){
		ready = new ExecutionQueue();
		waiting = new LinkedList<ProcessControlBlock>();
	}
	
	public void handleState(ProcessControlBlock pcb){
		
		// If PCB state is terminated, remove the process from the queue
		if (pcb.getState() == State.EXIT){
			removePCB(pcb.getPID());
		}
	}
	
	
	public void insertPCB(Process p){
		// If ram is available, add to ready queue
		ProcessControlBlock pcb = new ProcessControlBlock(p);
		ready.enQueue(pcb);
		pcb.setState(State.READY);
		
		// Else add to waiting queue
		// waiting.add(pcb);
		// pcb.setState(State.WAIT);
	}
	
	public void removePCB(int PID){
		ready.remove(PID);
	}
	
	public ProcessControlBlock nextProcess(){
		ProcessControlBlock pcb = ready.deQueue();
		if (pcb == null){
			return null;
		}
		
		if (pcb.getState() != State.WAIT){
			pcb.setState(State.RUN);
		}
		
		return pcb;
	}
	
	public ExecutionQueue getReadyQueue(){
		return ready;
	}
	
	public void setQuantum(int q){
		quantum = q;
	}
	//public ExecutionQueue getWaitingQueue(){
	//	return waiting;
	//}


	

}