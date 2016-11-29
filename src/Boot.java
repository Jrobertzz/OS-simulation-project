/*
 * main java class, initializes operating system simulation
 * 
 * created by Jrobertzz on 11/10/2016
 */
public class Boot {

	public static void main(String[] args) {
		Scheduler schedule = new Scheduler();
		Memory RAM = new Memory();
		GraphicalUserInterface GUI = new GraphicalUserInterface();
		CentralProcessingUnit CPU = new CentralProcessingUnit(RAM);
		CPU processor = new CPU(CPU);
		RAMFrames frames = new RAMFrames(RAM);
		Interpretor testing = new Interpretor();
		
		/**************************TESTING CPU ON BOOT*************************/
		/**/		Interpretor test = new Interpretor();					/**/
		/**/		//String testopcode = "test";							/**/
		/**/		//byte[] initramfs = test.stringToByteArray(testopcode);/**/
		/**/		//System.out.println(test.byteArrayToString(initramfs));/**/
		/**/		//CPU.setOpcode(0, initramfs);							/**/
		/**/		//System.out.println(test.byteArrayToString(CPU.cache));/**/
		/**/		CPU.setOpcode(0, test.stringToByteArray("set R4 int 4"));	/**/
		/**/		CPU.cycle();											/**/
		/**/		//CPU.setOpcode(0, test.stringToByteArray("load R4"));	/**/
		/**/		//System.out.println("CPU output:	" + CPU.cycle());		/**/
		/**/		CPU.setOpcode(0, test.stringToByteArray("add 3 4"));	/**/
					CPU.cycle();
		/**/		CPU.setOpcode(0, test.stringToByteArray("sub 10 40"));	/**/
					CPU.cycle();
		/**/		CPU.setOpcode(0, test.stringToByteArray("mul 3 6"));	/**/
					CPU.cycle();
		/**/		CPU.setOpcode(0, test.stringToByteArray("div 20 2"));	/**/
					CPU.cycle();
		/**************************TESTING CPU ON BOOT*************************/
		Process newProcess = new Process(RAM);

		//byte[] initramfs = new byte[1];
		//initramfs[0] = 0;
		//CPU.setCache(0, initramfs);
		//Process GUI = new Process(0, graphicalUserInterface.priority);
		
		
		
		//MemTest testmem = new MemTest(RAM, GUI);
		//File tests = new File("test.txt", GUI);
		//CPU.cycle();
	}

}
