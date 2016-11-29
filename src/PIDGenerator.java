/*
 * created 11/26/2016
 * 
 * Author: Jrobertzz
 */

public final class PIDGenerator {
	// A static variable which keeps track of the last PID used
	private static int lastPID;

	// Set the starting PID to -1
	private PIDGenerator(){
		lastPID = -1;
	}
	
	// When a new PID is created, the last PID is incremented and the new value is a new PID
	public static int newPID(){
		// Generate a new PID and return it
		lastPID++;
		return lastPID;
	}
}
