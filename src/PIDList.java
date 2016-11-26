import java.util.ArrayList;

/*
 * created 11/26/2016
 * 
 * Author: Jrobertzz
 */

public class PIDList {

private static ArrayList<Integer> PIDs;

	public PIDList(){
		PIDs = new ArrayList<Integer>();
	}
	
	public void addPID(int ID){
		PIDs.add(ID);
	}
	
	public void removePID(int ID){
		PIDs.remove(PIDs.indexOf(ID));
	}
	
	public boolean PIDExists(int ID){
		return PIDs.contains(ID);
	}
}
