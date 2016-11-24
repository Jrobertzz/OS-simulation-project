import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Creates a file with 8192000000 0's, or 1 GB
 * of space zeroed out
 * 
 * created by Jrobertz
 */
public class GenerateHardDrive {

	public static void main(String[] args) throws IOException {
		byte[] HDD = new byte[1024000000];
		for(byte b : HDD){
			b = 0;
		}
		FileOutputStream hardDrive = new FileOutputStream("HDD");
		hardDrive.write(HDD);
		hardDrive.close();
		System.exit(0);
	}

}
