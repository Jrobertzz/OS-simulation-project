import java.util.Comparator;
import java.util.PriorityQueue;

public class ExecutionQueue{

    
	private PriorityQueue<ProcessControlBlock> queue;
	
	public ExecutionQueue(){
		queue = new PriorityQueue<ProcessControlBlock>();
	}
	public ExecutionQueue(Comparator<ProcessControlBlock> c){
		queue = new PriorityQueue<ProcessControlBlock>(c);
	}
	
	public boolean enQueue(ProcessControlBlock pcb){
		return queue.add(pcb);
	}
	
	public boolean deQueue(int PID){
		// Find the PCB with the matching id and remove it
		for (ProcessControlBlock pcb : queue){
			if (pcb.getPID()==PID){
				return queue.remove(pcb);
			}
		}
		return false;
	}
	
	public ProcessControlBlock deQueue(){
		return queue.poll();
	}
	
	public void printQueue(){
		while (!queue.isEmpty()){
			ProcessControlBlock pcb = this.deQueue();
			System.out.println("" + pcb.getPID() + ": " + pcb.getPriority());
		}
	}
	
	
}