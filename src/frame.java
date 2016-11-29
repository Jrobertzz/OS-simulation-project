
public class frame extends Memory{
	private static byte[] frame;
	private int defaultSize = 1024, size;
	private int offset;
	private int memPointer;
	private Memory RAM;
	public frame(int frameNum, Memory temp){
		size = defaultSize;
		RAM = temp;
		frame = new byte[size];
		memPointer = frameNum * 1024;
	}
	public void setFrame(byte[] input){
		System.out.println("kjoihsarg");
		super.SET(input, memPointer, size);;
	}
	public byte[] getFrame(){
		return super.GET(memPointer, size);
	}
}
