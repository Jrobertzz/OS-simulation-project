
public class RAMFrames {
	byte[] frames;
	public RAMFrames(Memory RAM){
		frames = new byte[256];	//1 = used RAM, 0 = unallocated, each byte is in reference to a 1 kB frame
		for(byte b : frames){
			b = 0;
		}
		frames[0] = 1;
		RAM.SET(frames, 0, 256);
	}
}
