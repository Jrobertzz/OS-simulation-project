import java.util.PriorityQueue;

public class EventQueue {
	PriorityQueue events;
		public EventQueue(){
			events = new PriorityQueue();
		}
		
		public void add(EventControlBlock ECB){
			events.add(ECB);
		}
		
		public void remove(EventControlBlock ECB){
			events.remove(ECB);
		}
		
}
