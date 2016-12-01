import java.util.ArrayList;
import java.util.Formatter;
import java.util.StringTokenizer;

/*
 * CPU class
 * one loop is one "tick" or advanceClock
 * will need to add basic commands
 * I think(mov mult etc.)
 * 
 * Created by Jrobertzz 11/10/2016
 * 
 * use advanceClock() or cycle() to simulate on cpu cycle
 * you can use counter to count down a number of cycles
 * though you may need to add functionality to this class(or ask me to)
 */
public class CPU {
	private static int counter;
	private static String opcode;
	private static int opcodeLength;
	private static int instructionPointer;
	private static String command;
	private static Interpretor cache_interpretor;
	private static int advanceClocks;
	private static Register[] registers;
	private static byte[] cache;
	private static CPU cpu;
	boolean interupt;
	
	
	//THESE METHODS ARE PARTIALLY IMPLEMENTED ONLY BECAUE RUBRIC WANTS THEM	****************//***
																							//***
		public void runClock(){																//***
			interupt = cache_interpretor.byteArrayToBoolean(registers[15].getData());		//***
			while(!interupt){																//***
				advanceClock();																//***
			}																				//***
		}																					//***
																							//***
		public void advanceClock(){															//***
			if(!interupt)																	//***
				cycle();																	//***
			else pause();																	//***
		}																					//***
		/***************************************************************************************/

		/********************************CURRENTLY NOT USED*************************************/
		public void setInterupt(boolean force){												//***
			interupt = force;																//***
		}																					//***
																							//***
		public void pause(){																//***
			if(interupt){																	//***
				System.out.println("interupt");												//***
			}																				//***
			//System.out.println("next cycle");												//***
			cycle();																		//***
		}																					//***
																							//***
		public boolean detectInterupt(){													//***
			if(interupt){																	//***
				System.out.println("interupt");												//***
				interupt = false;															//***
				registers[15].setData(cache_interpretor.booleanToByteArray(true));			//***
				return true;																//***
			}																				//***
			return false;																	//***
		}																					//***
		/***************************************************************************************/

		/***********************SETS OFFSET OF INSTRUCTION IN CACHE*****************************/
		public void setInstructionPointer(int p){											//***
			instructionPointer = p;															//***
		}																					//***
		/***************************************************************************************/

		/***********************SETS LENGTH OF INSTRUCTION IN CACHE*****************************/
		public void setOpLength(int x){														//***
			opcodeLength = x;																//***
		}																					//***
		/***************************************************************************************/

		/********************************CONSTRUCTOR********************************************/
		public CPU(Memory RAM){																//***
			cache_interpretor = new Interpretor();											//***
			registers = new Register[16];	//16 registers stored in array					//***
			cache = new byte[1024];		//1 kilobyte cpu cache								//***
			byte[] nullReg = {0,0,0,0};														//***
			for(int k = 0; k < registers.length; k++){										//***
				registers[k] = new Register();												//***
			}																				//***
			for(Byte b : cache){															//***
				b = 0;																		//***
			}																				//***
			instructionPointer = 0;															//***
		}																					//***
		/***************************************************************************************/

		/********************************SETS ESTIMATED COUNT TILL NEXT INTERUPT****************/
		public void setCounter(int count){													//***
			counter = count;																//***
		}																					//***
		public void setCache(int location, byte[] data){									//***
			for(int i = 0; i < data.length; i++){											//***
				cache[location + i] = data[i];												//***
			}																				//***
		}																					//***
		/***************************************************************************************/

		/************************SETS CPU INSTRUCTION IN CACHE**********************************/
		public void setOpcode(int location, byte[] data){									//***
			for(int i = 0; i < data.length; i++){											//***
				cache[location + i] = data[i];												//***
				byte[] b = new byte[1];														//***
				b[0] = cache[location + i];													//***
				System.out.println(cache_interpretor.byteArrayToString(cache));				//***
			}																				//***
			opcodeLength=data.length;														//***
		}																					//***
		/***************************************************************************************/
		
		

		/***************************************************************************************/
		/**********************************CPU CYCLE********************************************/
		/***************************************************************************************/
		public byte[] cycle(){
			counter--;	/***	DECREASES CYCLES TILL ESTIMATED INTERUPT BY 1	***/
				
			
			/**************	FETCHES COMMAND FROM CACHE(AS IS IN RUBRIC)	***********/
				byte[] bytecode = new byte[opcodeLength];
				for(int i = 0; i < opcodeLength; i++){
					bytecode[i] = cache[i + instructionPointer];
					System.out.println("bytecode: " + cache_interpretor.byteArrayToString(bytecode));
				}
				
				opcode = cache_interpretor.byteArrayToString(bytecode);
				//System.out.println("OPEWIROIHETRBO:::" + opcode);
				String ops[] = opcode.split("\\s+");														//OPS DECLARED
				//System.out.println("CYCLE ====================================== " + opcode);


				/**************************************************************************************/
				/***								COMPLICATED PART								***/
				/**************************************************************************************/
				
				//this is a tree of switches, detailing how each command is interpreted by cpu
				//ops[] is an array of elements from the command that was stored in cache
				//with space as a delimiter. ops[0] being the command, EX. load or add,
				//and the other elements in ops[] are the parameters, so given the command "set R3 int 7"
				//it will process command set, which requires parameters <register> <data type> <value>
				
				switch (ops[0]){
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
					}
					break;
				case "set":
					switch(ops[2]){
						case "int":
							Integer temp = null;
							temp = Integer.valueOf(ops[3]);
							System.out.println("VALUE OF TEMP::		" + temp);
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
						break;
						
						case "bool":
						switch(ops[1]){
							case "R1":
								if(ops[2] == "true")
									registers[0].setData(cache_interpretor.booleanToByteArray(true));
								else
									registers[0].setData(cache_interpretor.booleanToByteArray(false));								
								break;
							case "R2":
								if(ops[2] == "true")
									registers[1].setData(cache_interpretor.booleanToByteArray(true));
								else
									registers[1].setData(cache_interpretor.booleanToByteArray(false));								
								break;
							case "R3":
								if(ops[2] == "true")
									registers[2].setData(cache_interpretor.booleanToByteArray(true));
								else
									registers[2].setData(cache_interpretor.booleanToByteArray(false));								
								break;
							case "R4":
								if(ops[2] == "true")
									registers[3].setData(cache_interpretor.booleanToByteArray(true));
								else
									registers[3].setData(cache_interpretor.booleanToByteArray(false));								
								break;
							case "R5":
								if(ops[2] == "true")
									registers[4].setData(cache_interpretor.booleanToByteArray(true));
								else
									registers[4].setData(cache_interpretor.booleanToByteArray(false));								
								break;
							case "R6":
								if(ops[2] == "true")
									registers[5].setData(cache_interpretor.booleanToByteArray(true));
								else
									registers[5].setData(cache_interpretor.booleanToByteArray(false));								
								break;
							case "R7":
								if(ops[2] == "true")
									registers[6].setData(cache_interpretor.booleanToByteArray(true));
								else
									registers[6].setData(cache_interpretor.booleanToByteArray(false));								
								break;
							case "R8":
								if(ops[2] == "true")
									registers[7].setData(cache_interpretor.booleanToByteArray(true));
								else
									registers[7].setData(cache_interpretor.booleanToByteArray(false));								
								break;
							case "R9":
								if(ops[2] == "true")
									registers[8].setData(cache_interpretor.booleanToByteArray(true));
								else
									registers[8].setData(cache_interpretor.booleanToByteArray(false));								
								break;
							case "R10":
								if(ops[2] == "true")
									registers[9].setData(cache_interpretor.booleanToByteArray(true));
								else
									registers[9].setData(cache_interpretor.booleanToByteArray(false));								
								break;
							case "R11":
								if(ops[2] == "true")
									registers[10].setData(cache_interpretor.booleanToByteArray(true));
								else
									registers[10].setData(cache_interpretor.booleanToByteArray(false));								
								break;
							case "R12":
								if(ops[2] == "true")
									registers[11].setData(cache_interpretor.booleanToByteArray(true));
								else
									registers[11].setData(cache_interpretor.booleanToByteArray(false));								
								break;
							case "R13":
								if(ops[2] == "true")
									registers[12].setData(cache_interpretor.booleanToByteArray(true));
								else
									registers[12].setData(cache_interpretor.booleanToByteArray(false));								
								break;
							case "R14":
								if(ops[2] == "true")
									registers[13].setData(cache_interpretor.booleanToByteArray(true));
								else
									registers[13].setData(cache_interpretor.booleanToByteArray(false));								
								break;
							case "R15":
								if(ops[2] == "true")
									registers[14].setData(cache_interpretor.booleanToByteArray(true));
								else
									registers[14].setData(cache_interpretor.booleanToByteArray(false));								
								break;
							case "R16":
								if(ops[2] == "true")
									registers[15].setData(cache_interpretor.booleanToByteArray(true));
								else
									registers[15].setData(cache_interpretor.booleanToByteArray(false));								
								break;
						}
						break;
					}
					break;
				case "add":
					
					command = String.format("set R1 int %s", ops[1]);
					System.out.println("COMMAND 1:::" + command);
					setOpcode(0, cache_interpretor.stringToByteArray(command));
					
					command = String.format("set R2 int %s", ops[2]);
					System.out.println("COMMAND 2:::" + command);
					setOpcode(20, cache_interpretor.stringToByteArray(command));

					command = "adc";
					System.out.println("COMMAND 3:::" + command);
					setOpcode(50, cache_interpretor.stringToByteArray(command));
					
					break;
				
				case "adc":
					System.out.println("reg1: " + cache_interpretor.byteArrayToInt(registers[0].getData()));
					System.out.println("reg2: " + cache_interpretor.byteArrayToInt(registers[1].getData()));

					int ans = (cache_interpretor.byteArrayToInt(registers[0].getData()) + cache_interpretor.byteArrayToInt(registers[1].getData()));
					System.out.println("ANS  " + ans);
					command = String.format("set R3 int %s", ans);
					setOpcode(0, cache_interpretor.stringToByteArray(command));
					
					break;
				
				case "sub":
					counter = 3;
					
					command = String.format("set R1 int %s", ops[1]);
					setOpcode(0, cache_interpretor.stringToByteArray(command));
					
					
					command = String.format("set R2 int %s", ops[2]);
					setOpcode(0, cache_interpretor.stringToByteArray(command));
					
					
					command = String.format("set R3 int %s", (cache_interpretor.byteArrayToInt(registers[0].getData()) + -cache_interpretor.byteArrayToInt(registers[1].getData())));
					setOpcode(0, cache_interpretor.stringToByteArray(command));
					
					
					System.out.println(cache_interpretor.byteArrayToInt(registers[2].getData()));
					break;
					
				case "mul":
					counter = 35;	//largely a guess
					
					command = String.format("set R1 int %s", ops[1]);
					setOpcode(0, cache_interpretor.stringToByteArray(command));
					
					
					command = String.format("set R2 int %s", ops[1]);
					setOpcode(0, cache_interpretor.stringToByteArray(command));
					
					
					command = String.format("set R15 int %s", ops[2]);
					setOpcode(0, cache_interpretor.stringToByteArray(command));
					

					command = String.format("set R14 int %s", 1);
					setOpcode(0, cache_interpretor.stringToByteArray(command));
					
					
					while(cache_interpretor.byteArrayToInt(registers[14].getData())>1){
						int temp = (cache_interpretor.byteArrayToInt(registers[0].getData()) + cache_interpretor.byteArrayToInt(registers[1].getData()));
						command = String.format("set R3 int %s", temp);
						setOpcode(0, cache_interpretor.stringToByteArray(command));
						
					
						command = String.format("set R2 int %s", cache_interpretor.byteArrayToInt(registers[2].getData()));
						setOpcode(0, cache_interpretor.stringToByteArray(command));
						

						temp = cache_interpretor.byteArrayToInt(registers[14].getData()) + -cache_interpretor.byteArrayToInt(registers[13].getData());
						command = String.format("set R15 int %s", temp);
						setOpcode(0, cache_interpretor.stringToByteArray(command));
						
					}
					System.out.println(cache_interpretor.byteArrayToInt(registers[2].getData()));
					break;

				case "div":
					counter = 50;	//largely a guess
					
					command = String.format("set R1 int %s", ops[1]);
					setOpcode(0, cache_interpretor.stringToByteArray(command));
					
					
					command = String.format("set R2 int %s", ops[2]);
					System.out.println("COMMAND 2:::" + command);
					setOpcode(0, cache_interpretor.stringToByteArray(command));
					

					command = String.format("set R3 int %s", ops[1]);
					setOpcode(0, cache_interpretor.stringToByteArray(command));
					

					command = String.format("set R15 int %s", 0);
					setOpcode(0, cache_interpretor.stringToByteArray(command));
					

					command = String.format("set R14 int %s", 1);
					setOpcode(0, cache_interpretor.stringToByteArray(command));
					
					
					while(cache_interpretor.byteArrayToInt(registers[2].getData()) >= cache_interpretor.byteArrayToInt(registers[1].getData())){
						int temp = cache_interpretor.byteArrayToInt(registers[0].getData()) + -cache_interpretor.byteArrayToInt(registers[1].getData());
						command = String.format("set R3 int %s", temp);
						setOpcode(0, cache_interpretor.stringToByteArray(command));
						

						command = String.format("set R1 int %s", cache_interpretor.byteArrayToInt(registers[2].getData()));
						setOpcode(0, cache_interpretor.stringToByteArray(command));
						
						
						temp = cache_interpretor.byteArrayToInt(registers[14].getData()) + cache_interpretor.byteArrayToInt(registers[13].getData());
						command = String.format("set R13 int %s", temp);
						setOpcode(0, cache_interpretor.stringToByteArray(command));
						

						command = String.format("set R15 int %s", cache_interpretor.byteArrayToInt(registers[12].getData()));
						setOpcode(0, cache_interpretor.stringToByteArray(command));
						
					}
					System.out.println(cache_interpretor.byteArrayToInt(registers[14].getData()));
					break;
					
					
				default:
					System.out.println("opcode not found");
				}
				return new byte[] {0};
		}
	}
