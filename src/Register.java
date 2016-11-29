
public class Register {
	private byte[] data;
	public Register(){
		data = new byte[4];
	}
	public void setData(byte[] input){
		data = input;
	}
	public byte[] getData(){
		return data;
	}
}
