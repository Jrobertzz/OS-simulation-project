public class Process {
	private int PID, arrivalTime, CPUTime, reqMem;
	private frame[] localMem;
	Memory RAM;
	RAMFrames frames;
	
	public Process(Memory t, RAMFrames f){
		//System.out.println();
		//System.out.println("1");
		frames = f;
		RAM = t;
		Interpretor byteInterpretor = new Interpretor();
		this.PID = PIDGenerator.newPID();
		
		//System.out.println("2");
		
		// TESTINT
		reqMem = 50;
		System.out.println("3");
		setLocalMem();
		System.out.println("the first 4");
		byte[] test = byteInterpretor.stringToByteArray("THIS IS A TEST");
		System.out.println("test:::::  " + byteInterpretor.byteArrayToString(test));
		System.out.println("test:::::  " + localMem[25]);
		localMem[25].setFrame(test);
		System.out.println("test");
		System.out.println(byteInterpretor.byteArrayToString(localMem[25].getFrame()));
		
	}
	
	public int getPID(){
		return this.PID;
	}
	
	public Memory getRAM(){
		return RAM;
	}
	
	public void setLocalMem(){
		System.out.println("the 4");
		System.out.println("5");
		localMem = frames.allocateFrames(reqMem);
		System.out.println("the 6");
	}
	
	
}