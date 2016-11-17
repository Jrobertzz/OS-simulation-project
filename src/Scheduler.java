import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * Simple Scheduler, ideally broken up into
 * short term and long term schedulers
 * 
 * created be Jrobertzz
 */
public class Scheduler{
	ArrayList PIDs;
	public Scheduler(){
		PIDs = new ArrayList<Integer>();
		PriorityQueue waiting = new PriorityQueue();
		PriorityQueue ready = new PriorityQueue();
	}
	
	public ArrayList getPIDs(){
		return PIDs;
	}
	
	public static void add(int PID, int priority){
		
	}

	public static void remove(int PID){
		
	}
	

}
