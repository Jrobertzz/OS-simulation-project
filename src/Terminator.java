/*
 * Shell, named after linux terminal 'Terminator'
 * 
 * Author: Jrobertzz
 * 11/18/2016
 */
public class Terminator {
	public Terminator(String command){
		
		switch (command){
			case "PROC":break;
			case "MEM":break;
			case "LOAD":break;
			case "EXE":break;
			case "RESET":break;
			case "EXIT":System.exit(0);
			default:break;
		}
	}
}
