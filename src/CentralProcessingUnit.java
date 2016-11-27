import java.util.ArrayList;
import java.util.Formatter;
import java.util.StringTokenizer;

/*
 * CPU class
 * one loop is one "tick" or cycle
 * will need to add basic commands
 * I think(mov mult etc.)
 * 
 * Created by Jrobertzz 11/10/2016
 */
public class CentralProcessingUnit {
	private static boolean interupt;
	private static String opcode;
	private static int opcodeLength;
	private static int instructionPointer;
	private static String command;
	private static Interpretor cache_interpretor;
	private static int cycles;
	private static byte[] registers;
	private static byte[] cache;
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
		public byte cycle(){
			//for(;;) {	//compiled for loop is faster than compiled while loop
				
				byte[] bytecode = new byte[opcodeLength];
				for(int i = 0; i < opcodeLength; i++){
					bytecode[i] = cache[i];
				}
				opcode = cache_interpretor.byteArrayToString(bytecode);
				String ops[] = opcode.split("\\s+");
				
				switch (ops[0]){
				case "load":
					switch(ops[1]){
						case "R1":
							return registers[0];
						case "R2":
							return registers[1];
						case "R3":
							return registers[2];
						case "R4":
							return registers[3];
						case "R5":
							return registers[4];
						case "R6":
							return registers[5];
						case "R7":
							return registers[6];
						case "R8":
							return registers[7];
						case "R9":
							return registers[8];
						case "R10":
							return registers[9];
						case "R11":
							return registers[10];
						case "R12":
							return registers[11];
						case "R13":
							return registers[12];
						case "R14":
							return registers[13];
						case "R15":
							return registers[14];
						case "R16":
							return registers[15];
					}
				case "set":
					//StringTokenizer st = new StringTokenizer(ops[2]);
					Integer temp = null;
					System.out.println("VALUE OF OPS[]::		" + ops[0] + ops[1] + ops[2]);
					temp = Integer.valueOf(ops[2]);
					//int temp = Integer.parseInt(st.nextToken());
					if(temp == null){
						switch(ops[1]){
							case "R1":
								registers[0] = cache_interpretor.stringToByte(ops[2]);
								break;
							case "R2":
								registers[1] = cache_interpretor.stringToByte(ops[2]);
								break;
							case "R3":
								registers[2] = cache_interpretor.stringToByte(ops[2]);
								break;
							case "R4":
								registers[3] = cache_interpretor.stringToByte(ops[2]);
								break;
							case "R5":
								registers[4] = cache_interpretor.stringToByte(ops[2]);
								break;
							case "R6":
								registers[5] = cache_interpretor.stringToByte(ops[2]);
								break;
							case "R7":
								registers[6] = cache_interpretor.stringToByte(ops[2]);
								break;
							case "R8":
								registers[7] = cache_interpretor.stringToByte(ops[2]);
								break;
							case "R9":
								registers[8] = cache_interpretor.stringToByte(ops[2]);
								break;
							case "R10":
								registers[9] = cache_interpretor.stringToByte(ops[2]);
								break;
							case "R11":
								registers[10] = cache_interpretor.stringToByte(ops[2]);
								break;
							case "R12":
								registers[11] = cache_interpretor.stringToByte(ops[2]);
								break;
							case "R13":
								registers[12] = cache_interpretor.stringToByte(ops[2]);
								break;
							case "R14":
								registers[13] = cache_interpretor.stringToByte(ops[2]);
								break;
							case "R15":
								registers[14] = cache_interpretor.stringToByte(ops[2]);
								break;
							case "R16":
								registers[15] = cache_interpretor.stringToByte(ops[2]);
								break;
						}
					}
					else{
						switch(ops[1]){
							case "R1":
								registers[0] = cache_interpretor.intToByte(temp);
								break;
							case "R2":
								registers[1] = cache_interpretor.intToByte(temp);
								break;
							case "R3":
								registers[2] = cache_interpretor.intToByte(temp);
								break;
							case "R4":
								registers[3] = cache_interpretor.intToByte(temp);
								break;
							case "R5":
								registers[4] = cache_interpretor.intToByte(temp);
								break;
							case "R6":
								registers[5] = cache_interpretor.intToByte(temp);
								break;
							case "R7":
								registers[6] = cache_interpretor.intToByte(temp);
								break;
							case "R8":
								registers[7] = cache_interpretor.intToByte(temp);
								break;
							case "R9":
								registers[8] = cache_interpretor.intToByte(temp);
								break;
							case "R10":
								registers[9] = cache_interpretor.intToByte(temp);
								break;
							case "R11":
								registers[10] = cache_interpretor.intToByte(temp);
								break;
							case "R12":
								registers[11] = cache_interpretor.intToByte(temp);
								break;
							case "R13":
								registers[12] = cache_interpretor.intToByte(temp);
								break;
							case "R14":
								registers[13] = cache_interpretor.intToByte(temp);
								break;
							case "R15":
								registers[14] = cache_interpretor.intToByte(temp);
								break;
							case "R16":
								registers[15] = cache_interpretor.intToByte(temp);
								break;
						}
					}
					break;
					
				case "add":
					command = String.format("set R1 %s", ops[1]);
					this.setOpcode(0, cache_interpretor.stringToByteArray(command));
					this.cycle();
					
					command = String.format("set R2 %s", ops[2]);
					this.setOpcode(0, cache_interpretor.stringToByteArray(command));
					this.cycle();
					
					command = String.format("set R3 %s", (cache_interpretor.byteToInt(registers[0]) + cache_interpretor.byteToInt(registers[1])));
					this.setOpcode(0, cache_interpretor.stringToByteArray(command));
					this.cycle();
					
					System.out.println(cache_interpretor.byteToInt(registers[2]));
					break;
				
				case "sub":
					command = String.format("set R1 %s", ops[1]);
					this.setOpcode(0, cache_interpretor.stringToByteArray(command));
					this.cycle();
					
					command = String.format("set R2 %s", ops[2]);
					this.setOpcode(0, cache_interpretor.stringToByteArray(command));
					this.cycle();
					
					command = String.format("set R3 %s", (cache_interpretor.byteToInt(registers[0]) - cache_interpretor.byteToInt(registers[1])));
					this.setOpcode(0, cache_interpretor.stringToByteArray(command));
					this.cycle();
					
					System.out.println(cache_interpretor.byteToInt(registers[2]));
					break;
					
					
				case "test":
					System.out.println("worked");
					interupt = true;
					break;
				default:
					System.out.println("CRITICAL ERROR");
				}
				//if(interupt)
					//break;
			//}
			return 0;
		}
}
