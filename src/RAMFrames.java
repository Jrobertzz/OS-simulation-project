
public class RAMFrames {
	byte[] frames;
	Memory RAM;
	int i;
	int totalMemory = 256;
	public RAMFrames(Memory t){
		i = 0;
		RAM = t;
		frames = new byte[totalMemory];	//1 = used RAM, 0 = unallocated, each byte is in reference to a 1 kB frame
		//for(int k = 0; k < frames.length; k++){
			//Byte b = new Byte();
			//frames[12] = 0;
		//}
		frames[0] = 1;
		RAM.SET(frames, 0, totalMemory);
	}
	
	public frame[] allocateFrames(int memReq){
		int current = i;
		System.out.println("Allocating Memory:  " + memReq + "kb");
		frame[] memSpace = new frame[memReq];
		
		for (int k = 0; k < memReq; k++){
			memSpace[k] = new frame(k, RAM);
		}

		for (int k = i; k <= current + memSpace.length; k++) {
			if (frames[k] == 0) {
				frames[k] = 1;
				i++;
			}
		}
		RAM.SET(frames, 0, totalMemory);
		return memSpace;
	}
	

	public int memUsed(){
		int memUsed = 0;
		for(byte b : frames){
			if(b == 1){
				memUsed++;
			}
		}
		return memUsed;
	}
	
	public int availableMemory(){
		return totalMemory - memUsed();
	}
}
