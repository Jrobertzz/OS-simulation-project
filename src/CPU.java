
public class CPU {
	private static CentralProcessingUnit cpu;
	boolean interupt = false;
	public CPU(CentralProcessingUnit p){
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
