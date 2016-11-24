import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/*
 * Memory Hardware Class - 256 kB
 *
 * Created By wilsonjj 11/14/2016
 * 
 * Jrobertzz: basically created entire class
 */
 
public class Memory {
	byte[] RAM, output;
	int byteInt = 0, byte_inverse_counter = -1, byte_counter = -8, size = 256000;
	ByteArrayOutputStream write;
	ByteArrayInputStream read;
	public Memory(){
		RAM = new byte[size];
		write = new ByteArrayOutputStream();
		read = new ByteArrayInputStream(RAM);
    }
	
	
	public void SET(byte[] input, int offset,int length){
		for(int i = 0; i < length;i++){
			RAM[offset + i] = input[i];
		}
	}
	
	public byte[] GET(int offset, int length){
		byte[] output = new byte[length];
		for(int i = 0; i < length; i++){
			output[i] = RAM[offset + i];
		}
		return output;
	}
	

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