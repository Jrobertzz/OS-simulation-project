import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/*
 * Memory Hardware Class - 256 kB
 *
 * Created By wilsonjj 11/14/2016
 * 
 * EDIT BY JROBERTZZ:
 * using byte array as we can literally save a text file as a byte array then call it back as a file
 * need to add interpreter for byte files
 */
 
 public class Memory {
                    private int size = 256000;
                    byte[] RAM = new byte[size];
                    ByteArrayOutputStream write = new ByteArrayOutputStream();
                    ByteArrayInputStream read = new ByteArrayInputStream(RAM);
                    public void PUT(int data, int index){
                    	//read.read(b, off, len);
                    }
                    public void GET(int index){
                    	//write.write(byte[] b, int off, int len);
                    }
 }
