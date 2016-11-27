/*
 * CPU class
 * one loop is one "tick" or cycle
 * will need to add basic commands
 * I think(mov mult etc.)
 * 
 * Created by Jrobertzz 11/10/2016
 */
public class CentralProcessingUnit {
	static String opcode;
	static int opcodeLength;
	int instructionPointer;
	static Interpretor cache_interpretor;
	int cycles;
	byte[] registers;
	byte[] cache;
		public CentralProcessingUnit(Memory RAM){
			cache_interpretor = new Interpretor();
			registers = new byte[16];	//16 registers stored in array
			cache = new byte[1024];		//1 kilobyte cpu cache
			for(Byte b : registers){
				b = 0;
			}
			for(Byte b : cache){
				b = 0;
			}
			instructionPointer = 0;
		}
		public void setCache(int location, byte[] data){
			for(int i = 0; i < data.length; i++){
				cache[location + i] = data[i];
			}
		}
		public void setOpcode(int location, byte[] data){
			for(int i = 0; i < data.length; i++){
				cache[location + i] = data[i];
			}
			opcodeLength=data.length;
		}
		public void cycle(){
			for(;;) {	//compiled for loop is faster than compiled while loop
				
				byte[] bytecode = new byte[opcodeLength];
				for(int i = 0; i < opcodeLength; i++){
					bytecode[i] = cache[i];
				}
				opcode = cache_interpretor.byteArrayToString(bytecode);
				
				switch (opcode){
				case "test":
					System.out.println("worked");
					break;
				default:
					System.out.println("CRITICAL ERROR");
				}
			}
		}
}
