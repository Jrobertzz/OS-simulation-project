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
	private RAMFrames frames;
	
	private int quantum = 20;

	public Scheduler(RAMFrames frames){
		ready = new ExecutionQueue();
		waiting = new LinkedList<ProcessControlBlock>();
		this.frames = frames;
	}
	
	public void handleState(ProcessControlBlock pcb){
		
		// If PCB state is terminated, remove the process from the queue
		if (pcb.getState() == State.EXIT){
			removePCB(pcb.getPID());
		}
	}
	
	
	public void insertPCB(Process p){
		ProcessControlBlock pcb = new ProcessControlBlock(p);
		
		// If memory is available, add to ready queue
		if (frames.availableMemory() - p.getRequiredMemory() >= 0){	
			ready.enQueue(pcb);
			frames.allocateFrames(p.getRequiredMemory());
			pcb.setState(State.READY);
		}
		
		// Otherwise add to wait queue
		else {
			waiting.add(pcb);
			pcb.setState(State.WAIT);
		}
	}
	
	// Remove a job from the ready queue
	public void removePCB(int PID){
		ready.remove(PID);
	}
	
	// Retrieve the next job in the ready queue
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
	
	// Set the time quantum for Round Robin
	public void setQuantum(int q){
		quantum = q;
	}
		
	public ExecutionQueue getReadyQueue(){
		return ready;
	}
	
	public List<ProcessControlBlock> getWaitingQueue(){
		return waiting;
	}


	

}