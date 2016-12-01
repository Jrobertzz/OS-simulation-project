public class Process {
	private int PID, arrivalTime, CPUTime, reqMem;
	private frame[] localMem;
	Memory RAM;
	RAMFrames frames;
	
	public Process(Memory t, RAMFrames f){
		frames = f;
		RAM = t;
		this.PID = PIDGenerator.newPID();		
	}
	
	public int getPID(){
		return this.PID;
	}
	
	public Memory getRAM(){
		return RAM;
	}
	
	public int getRequiredMemory(){
		return reqMem;
	}
	
	public void setLocalMem(){
		localMem = frames.allocateFrames(reqMem);
	}
	
	
}