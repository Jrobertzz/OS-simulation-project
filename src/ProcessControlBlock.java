//just look here https://en.wikipedia.org/wiki/Process_control_block
public class ProcessControlBlock {
	int PID;
	int priority, defaultPriority = 5;
	public ProcessControlBlock(Process p, PIDList PIDs){
		int k = 0;
		while(k==0){
			PID = (int)(Math.random()*100);
			if(!PIDs.PIDExists(PID)){
				k = 1;
			}
		}
		priority = defaultPriority;
	}
}
