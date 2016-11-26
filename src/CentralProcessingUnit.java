/*
 * CPU class
 * one loop is one "tick" or cycle
 * will need to add basic commands
 * I think(mov mult etc.)
 * 
 * Created by Jrobertzz 11/10/2016
 */
public class CentralProcessingUnit {
		public void CentralProcessingUnit(){
			Byte[] registers = new Byte[16];	//16 registers stored in array
			Byte[] cache = new Byte[1024];		//1 kilobyte cpu cache
			for(Byte b : registers){
				b = 0;
			}
			for(Byte b : cache){
				b = 0;
			}
		}
		public void cycle(){
			for(;;) {	//compiled for loop is faster than compiled while loop
				
			}
		}
}
