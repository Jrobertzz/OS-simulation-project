
public class CPUbackup {
	private static CPU cpu;
	boolean interupt = false;
	public CPUbackup(CPU p){
		cpu = p;
	}
	
	public void advanceClock(){
		detectInterupt();
		cpu.cycle();
	}
	
	public void detectInterupt(){
		if(interupt){
			
		}
	}
}
