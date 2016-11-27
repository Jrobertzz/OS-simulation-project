import java.math.BigInteger;
import java.nio.ByteBuffer;

public class Interpretor {
	public byte[] intToByteArray(int a){
		return BigInteger.valueOf(a).toByteArray();
	}
	public int byteArrayToInt(byte[] b){
		return new BigInteger(b).intValue();
	}
	
	public byte[] stringToByteArray(String a){
		return a.getBytes();
	}
	public String byteArrayToString(byte[] a){
		return new String(a);
	}
	public Byte stringToByte(String a){
		return (a.getBytes())[0];
	}

	public byte[] charToByteArray(char a){
		String b = Character.toString(a);
		return b.getBytes();
	}
	public char byteArrayToChar(byte[] a){
		String b = new String(a);
		return b.toCharArray()[0];
	}

	public byte[] doubleToByteArray(double a){
		byte[] bite = new byte[8];
		ByteBuffer.wrap(bite).putDouble(a);
		return bite;
	}
	public double byteArrayToDouble(byte[] a){
		return ByteBuffer.wrap(a).getDouble();
	}

	public byte[] floatToByteArray(float a){
		byte[] bite = new byte[4];
		ByteBuffer.wrap(bite).putFloat(a);
		return bite;
	}
	public float byteArrayToFloat(byte[] a){
		return ByteBuffer.wrap(a).getFloat();
	}

	public byte[] longToByteArray(long a){
		byte[] bite = new byte[8];
		ByteBuffer.wrap(bite).putLong(a);
		return bite;
	}
	public long byteArrayToLong(byte[] a){
		return ByteBuffer.wrap(a).getLong();
	}

	public byte[] shortToByteArray(short a){
		byte[] bite = new byte[2];
		ByteBuffer.wrap(bite).putShort(a);
		return bite;
	}
	public float byteArrayToShort(byte[] a){
		return ByteBuffer.wrap(a).getShort();
	}

	public byte[] booleanToByteArray(Boolean a){
		return new byte[]{(byte) (a? 1:0)};
	}
	public boolean byteArrayToBoolean(byte[] a){
		//byte vIn = 1;
		return a[0]!=0;
	}
}
