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
	private static Register[] registers;
	private static byte[] cache;
		public CentralProcessingUnit(Memory RAM){
			cache_interpretor = new Interpretor();
			registers = new Register[16];	//16 registers stored in array
			cache = new byte[1024];		//1 kilobyte cpu cache
			byte[] nullReg = {0,0,0,0};
			for(int k = 0; k < registers.length; k++){
				registers[k] = new Register();
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
			System.out.println(cache_interpretor.byteArrayToString(data));
			for(int i = 0; i < data.length; i++){
				cache[location + i] = data[i];
			}
			System.out.println(cache_interpretor.byteArrayToString(cache));
			opcodeLength=data.length;
		}
		public void cycle(){
			//for(;;) {	//compiled for loop is faster than compiled while loop
				
				byte[] bytecode = new byte[opcodeLength];
				for(int i = 0; i < opcodeLength; i++){
					bytecode[i] = cache[i];
				}
				opcode = cache_interpretor.byteArrayToString(bytecode);
				String ops[] = opcode.split("\\s+");
				
				switch (ops[0]){
				/*
				case "load":
					switch(ops[1]){
						case "R1":
							return registers[0].getData();
						case "R2":
							return registers[1].getData();
						case "R3":
							return registers[2].getData();
						case "R4":
							return registers[3].getData();
						case "R5":
							return registers[4].getData();
						case "R6":
							return registers[5].getData();
						case "R7":
							return registers[6].getData();
						case "R8":
							return registers[7].getData();
						case "R9":
							return registers[8].getData();
						case "R10":
							return registers[9].getData();
						case "R11":
							return registers[10].getData();
						case "R12":
							return registers[11].getData();
						case "R13":
							return registers[12].getData();
						case "R14":
							return registers[13].getData();
						case "R15":
							return registers[14].getData();
						case "R16":
							return registers[15].getData();
					}*/
				case "set":
					switch(ops[2]){
						case "int":
							Integer temp = null;
							//System.out.println("VALUE OF OPS[]::		" + ops[0] + ops[1] + ops[2] + ops[3]);
							temp = Integer.valueOf(ops[3]);
							switch(ops[1]){
							case "R1":
								registers[0].setData(cache_interpretor.intToByteArray(temp));
								System.out.println("LUGtrsjJWF  " + cache_interpretor.byteArrayToInt(registers[0].getData()));
								break;
							case "R2":
								System.out.println("reg0+++: " + cache_interpretor.byteArrayToInt(registers[0].getData())  );
								registers[1].setData(cache_interpretor.intToByteArray(temp));
								System.out.println("reg0+++: " + cache_interpretor.byteArrayToInt(registers[0].getData())  );
								break;
							case "R3":
								registers[2].setData(cache_interpretor.intToByteArray(temp));
								break;
							case "R4":
								registers[3].setData(cache_interpretor.intToByteArray(temp));
								System.out.println(cache_interpretor.byteArrayToInt(registers[3].getData()));
								break;
							case "R5":
								registers[4].setData(cache_interpretor.intToByteArray(temp));
								break;
							case "R6":
								registers[5].setData(cache_interpretor.intToByteArray(temp));
								break;
							case "R7":
								registers[6].setData(cache_interpretor.intToByteArray(temp));
								break;
							case "R8":
								registers[7].setData(cache_interpretor.intToByteArray(temp));
								break;
							case "R9":
								registers[8].setData(cache_interpretor.intToByteArray(temp));
								break;
							case "R10":
								registers[9].setData(cache_interpretor.intToByteArray(temp));
								break;
							case "R11":
								registers[10].setData(cache_interpretor.intToByteArray(temp));
								break;
							case "R12":
								registers[11].setData(cache_interpretor.intToByteArray(temp));
								break;
							case "R13":
								registers[12].setData(cache_interpretor.intToByteArray(temp));
								break;
							case "R14":
								registers[13].setData(cache_interpretor.intToByteArray(temp));
								break;
							case "R15":
								registers[14].setData(cache_interpretor.intToByteArray(temp));
								break;
							case "R16":
								registers[15].setData(cache_interpretor.intToByteArray(temp));
								break;
							
							}
							break;
						case "string":
						switch(ops[1]){
							case "R1":
								registers[0].setData(cache_interpretor.stringToByteArray(ops[2]));
								break;
							case "R2":
								registers[1].setData(cache_interpretor.stringToByteArray(ops[2]));
								break;
							case "R3":
								registers[2].setData(cache_interpretor.stringToByteArray(ops[2]));
								break;
							case "R4":
								registers[3].setData(cache_interpretor.stringToByteArray(ops[2]));
								break;
							case "R5":
								registers[4].setData(cache_interpretor.stringToByteArray(ops[2]));
								break;
							case "R6":
								registers[5].setData(cache_interpretor.stringToByteArray(ops[2]));
								break;
							case "R7":
								registers[6].setData(cache_interpretor.stringToByteArray(ops[2]));
								break;
							case "R8":
								registers[7].setData(cache_interpretor.stringToByteArray(ops[2]));
								break;
							case "R9":
								registers[8].setData(cache_interpretor.stringToByteArray(ops[2]));
								break;
							case "R10":
								registers[9].setData(cache_interpretor.stringToByteArray(ops[2]));
								break;
							case "R11":
								registers[10].setData(cache_interpretor.stringToByteArray(ops[2]));
								break;
							case "R12":
								registers[11].setData(cache_interpretor.stringToByteArray(ops[2]));
								break;
							case "R13":
								registers[12].setData(cache_interpretor.stringToByteArray(ops[2]));
								break;
							case "R14":
								registers[13].setData(cache_interpretor.stringToByteArray(ops[2]));
								break;
							case "R15":
								registers[14].setData(cache_interpretor.stringToByteArray(ops[2]));
								break;
							case "R16":
								registers[15].setData(cache_interpretor.stringToByteArray(ops[2]));
								break;
						}
							
					/*
					//StringTokenizer st = new StringTokenizer(ops[2]);
					Integer temp = null;
					System.out.println("VALUE OF OPS[]::		" + ops[0] + ops[1] + ops[2]);
					temp = Integer.valueOf(ops[2]);
					//int temp = Integer.parseInt(st.nextToken());
					if(temp == null){
						switch(ops[1]){
							case "R1":
								registers[0].setData(cache_interpretor.stringToByteArray(ops[2]));
								break;
							case "R2":
								registers[1].setData(cache_interpretor.stringToByteArray(ops[2]));
								break;
							case "R3":
								registers[2].setData(cache_interpretor.stringToByteArray(ops[2]));
								break;
							case "R4":
								registers[3].setData(cache_interpretor.stringToByteArray(ops[2]));
								break;
							case "R5":
								registers[4].setData(cache_interpretor.stringToByteArray(ops[2]));
								break;
							case "R6":
								registers[5].setData(cache_interpretor.stringToByteArray(ops[2]));
								break;
							case "R7":
								registers[6].setData(cache_interpretor.stringToByteArray(ops[2]));
								break;
							case "R8":
								registers[7].setData(cache_interpretor.stringToByteArray(ops[2]));
								break;
							case "R9":
								registers[8].setData(cache_interpretor.stringToByteArray(ops[2]));
								break;
							case "R10":
								registers[9].setData(cache_interpretor.stringToByteArray(ops[2]));
								break;
							case "R11":
								registers[10].setData(cache_interpretor.stringToByteArray(ops[2]));
								break;
							case "R12":
								registers[11].setData(cache_interpretor.stringToByteArray(ops[2]));
								break;
							case "R13":
								registers[12].setData(cache_interpretor.stringToByteArray(ops[2]));
								break;
							case "R14":
								registers[13].setData(cache_interpretor.stringToByteArray(ops[2]));
								break;
							case "R15":
								registers[14].setData(cache_interpretor.stringToByteArray(ops[2]));
								break;
							case "R16":
								registers[15].setData(cache_interpretor.stringToByteArray(ops[2]));
								break;
						}
					}
					else{
						switch(ops[1]){
							case "R1":
								registers[0].setData(cache_interpretor.intToByteArray(temp));
								break;
							case "R2":
								registers[1].setData(cache_interpretor.intToByteArray(temp));
								break;
							case "R3":
								registers[2].setData(cache_interpretor.intToByteArray(temp));
								break;
							case "R4":
								registers[3].setData(cache_interpretor.intToByteArray(temp));
								break;
							case "R5":
								registers[4].setData(cache_interpretor.intToByteArray(temp));
								break;
							case "R6":
								registers[5].setData(cache_interpretor.intToByteArray(temp));
								break;
							case "R7":
								registers[6].setData(cache_interpretor.intToByteArray(temp));
								break;
							case "R8":
								registers[7].setData(cache_interpretor.intToByteArray(temp));
								break;
							case "R9":
								registers[8].setData(cache_interpretor.intToByteArray(temp));
								break;
							case "R10":
								registers[9].setData(cache_interpretor.intToByteArray(temp));
								break;
							case "R11":
								registers[10].setData(cache_interpretor.intToByteArray(temp));
								break;
							case "R12":
								registers[11].setData(cache_interpretor.intToByteArray(temp));
								break;
							case "R13":
								registers[12].setData(cache_interpretor.intToByteArray(temp));
								break;
							case "R14":
								registers[13].setData(cache_interpretor.intToByteArray(temp));
								break;
							case "R15":
								registers[14].setData(cache_interpretor.intToByteArray(temp));
								break;
							case "R16":
								registers[15].setData(cache_interpretor.intToByteArray(temp));
								break;
						}
						*/
					}
					break;
					
				case "add":
					command = String.format("set R1 int %s", ops[1]);
					setOpcode(0, cache_interpretor.stringToByteArray(command));
					cycle();
					
					command = String.format("set R2 int %s", ops[2]);
					setOpcode(0, cache_interpretor.stringToByteArray(command));
					cycle();
					
					int ans = (cache_interpretor.byteArrayToInt(registers[0].getData()) + cache_interpretor.byteArrayToInt(registers[1].getData()));
					command = String.format("set R3 int %s", ans);
					setOpcode(0, cache_interpretor.stringToByteArray(command));
					cycle();
					
					System.out.println(cache_interpretor.byteArrayToInt(registers[2].getData()));
					break;
				
				case "sub":
					command = String.format("set R1 int %s", ops[1]);
					setOpcode(0, cache_interpretor.stringToByteArray(command));
					cycle();
					
					command = String.format("set R2 int %s", ops[2]);
					setOpcode(0, cache_interpretor.stringToByteArray(command));
					cycle();
					
					command = String.format("set R3 int %s", (cache_interpretor.byteArrayToInt(registers[0].getData()) + -cache_interpretor.byteArrayToInt(registers[1].getData())));
					setOpcode(0, cache_interpretor.stringToByteArray(command));
					cycle();
					
					System.out.println(cache_interpretor.byteArrayToInt(registers[2].getData()));
					break;
					
				case "mul":
					command = String.format("set R1 int %s", ops[1]);
					setOpcode(0, cache_interpretor.stringToByteArray(command));
					cycle();
					
					command = String.format("set R2 int %s", ops[1]);
					setOpcode(0, cache_interpretor.stringToByteArray(command));
					cycle();
					
					command = String.format("set R16 int %s", ops[2]);
					setOpcode(0, cache_interpretor.stringToByteArray(command));
					cycle();

					command = String.format("set R15 int %s", 1);
					setOpcode(0, cache_interpretor.stringToByteArray(command));
					cycle();
					
					while(cache_interpretor.byteArrayToInt(registers[15].getData())>1){
						int temp = (cache_interpretor.byteArrayToInt(registers[0].getData()) + cache_interpretor.byteArrayToInt(registers[1].getData()));
						command = String.format("set R3 int %s", temp);
						setOpcode(0, cache_interpretor.stringToByteArray(command));
						cycle();
					
						command = String.format("set R2 int %s", cache_interpretor.byteArrayToInt(registers[2].getData()));
						setOpcode(0, cache_interpretor.stringToByteArray(command));
						cycle();

						temp = cache_interpretor.byteArrayToInt(registers[15].getData()) + -cache_interpretor.byteArrayToInt(registers[14].getData());
						command = String.format("set R16 int %s", temp);
						setOpcode(0, cache_interpretor.stringToByteArray(command));
						cycle();
					}
					System.out.print(cache_interpretor.byteArrayToInt(registers[2].getData()));
					break;

				case "div":
					command = String.format("set R1 int %s", ops[1]);
					setOpcode(0, cache_interpretor.stringToByteArray(command));
					cycle();
					
					command = String.format("set R2 int %s", ops[2]);
					setOpcode(0, cache_interpretor.stringToByteArray(command));
					cycle();

					command = String.format("set R3 int %s", ops[1]);
					setOpcode(0, cache_interpretor.stringToByteArray(command));
					cycle();

					command = String.format("set R16 int %s", 0);
					setOpcode(0, cache_interpretor.stringToByteArray(command));
					cycle();

					command = String.format("set R15 int %s", 1);
					setOpcode(0, cache_interpretor.stringToByteArray(command));
					cycle();
					
					while(cache_interpretor.byteArrayToInt(registers[2].getData()) >= cache_interpretor.byteArrayToInt(registers[1].getData())){
						int temp = cache_interpretor.byteArrayToInt(registers[0].getData()) + -cache_interpretor.byteArrayToInt(registers[1].getData());
						command = String.format("set R3 int %s", temp);
						setOpcode(0, cache_interpretor.stringToByteArray(command));
						cycle();

						command = String.format("set R1 int %s", cache_interpretor.byteArrayToInt(registers[2].getData()));
						setOpcode(0, cache_interpretor.stringToByteArray(command));
						cycle();
						
						temp = cache_interpretor.byteArrayToInt(registers[15].getData()) + cache_interpretor.byteArrayToInt(registers[14].getData());
						command = String.format("set R14 int %s", temp);
						setOpcode(0, cache_interpretor.stringToByteArray(command));
						cycle();

						command = String.format("set R16 int %s", cache_interpretor.byteArrayToInt(registers[13].getData()));
						setOpcode(0, cache_interpretor.stringToByteArray(command));
						cycle();
					}
					System.out.print(cache_interpretor.byteArrayToInt(registers[15].getData()));
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
			//return new byte[] {0,0,0,0};
		}
}
