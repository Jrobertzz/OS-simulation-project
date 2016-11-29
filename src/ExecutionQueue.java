import java.util.PriorityQueue;

public class ExecutionQueue<E>{

    
	private PriorityQueue<E> queue;
	
	public ExecutionQueue(){
		queue = new PriorityQueue<E>();
	}
	
	public boolean enQueue(E e){
		return queue.add(e);
	}
	
	public boolean deQueue(E e){
		return queue.remove(e);
	}
	
	
}
