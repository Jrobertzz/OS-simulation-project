
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
		System.out.println("memeroewyflkadgnbpireg  " + memReq);
		frame[] memSpace = new frame[memReq];
		//System.out.println("7");
			for(int k = i; k < frames.length; k++){
				//System.out.println("8" + i);
				System.out.println("FRAME::  " + frames[k]);
				if(frames[k] == 0){
					System.out.println("FRAME  ::  ");
					frames[k] = 1;
					memSpace[i] = new frame(k, RAM);
					System.out.println("new frame");
					i++;
					System.out.println("FRAME::  " + k);
				}
				if(i >= memReq)
					break;
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
