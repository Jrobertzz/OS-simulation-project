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
 }