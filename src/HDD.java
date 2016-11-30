import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * Memory Hardware Class - 256 kB
 *
 * Created By wilsonjj 11/14/2016
 * 
 * Jrobertzz: basically created entire class
 */
 
public class HDD {
	public void SET(byte[] input, int offset, int length) throws IOException{
		if(offset >= 1024000000){
			System.out.println("You tried to write to a non-existant location");
		}
		else{
			RandomAccessFile RAF = new RandomAccessFile("HDD", "rw");
			RAF.seek(offset);
			RAF.write(input);
			RAF.close();
		}
	}
	
	public byte[] GET(int offset, int length) throws IOException{
		if(offset >= 1024000000){
			System.out.println("You tried to read from a non-existant location");
		}
		else{
			RandomAccessFile RAF = new RandomAccessFile("HDD", "rw");
			byte[] output = new byte[length];
			RAF.seek(offset);
			RAF.read(output, 0, length);
			RAF.close();
			return output;
		}
		return new byte[]{0};
	}
 }