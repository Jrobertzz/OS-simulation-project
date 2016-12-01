import java.io.IOException;

/*
 * main java class, initializes operating system simulation
 * 
 * created by Jrobertzz on 11/10/2016
 */
public class Boot {

	public static void main(String[] args) throws IOException {
		Memory RAM = new Memory();
		RAMFrames frames = new RAMFrames(RAM);
		CPU CPU = new CPU(RAM);
		GraphicalUserInterface GUI = new GraphicalUserInterface(CPU, frames);
		CPUbackup processor = new CPUbackup(CPU);
		Scheduler scheduler = new Scheduler(frames);
		//RAMFrames frames = new RAMFrames(RAM);
		
		
		/**************************TESTING CPU ON BOOT*************************/
		/**/		Interpretor test = new Interpretor();					/**/
		//CPU.setOpcode(0, test.stringToByteArray("set R16 boolean false"));	//SETS INTERUPT FLAG TO FALSE
		/**/		//String testopcode = "test";							/**/
		/**/		//byte[] initramfs = test.stringToByteArray(testopcode);/**/
		/**/		//System.out.println(test.byteArrayToString(initramfs));/**/
		/**/		//CPU.setOpcode(0, initramfs);							/**/
		/**/		//System.out.println(test.byteArrayToString(CPU.cache));/**/
		/**/		//CPU.setOpcode(0, test.stringToByteArray("set R4 int 4"));	/**/
		/**/		//CPU.cycle();											/**/
		/**/		//CPU.setOpcode(0, test.stringToByteArray("load R4"));	/**/
		/**/		//System.out.println("CPU output:	" + CPU.cycle());		/**/
		/**/		//CPU.setOpcode(0, test.stringToByteArray("add 3 4"));	/**/
					//CPU.advanceClock();
		/**/		//CPU.setOpcode(0, test.stringToByteArray("sub 10 40"));	/**/
					//CPU.cycle();
		/**/		//CPU.setOpcode(0, test.stringToByteArray("mul 3 6"));	/**/
					//CPU.advanceClock();
					//CPU.advanceClock();
					//CPU.advanceClock();
		/**/		//CPU.setOpcode(0, test.stringToByteArray("div 20 2"));	/**/
					//CPU.advanceClock();
					//CPU.advanceClock();
		/**************************TESTING CPU ON BOOT*************************/
		//Process newProcess = new Process(RAM);
		
		HDD testhdd = new HDD();
		byte[] fakehdd = test.stringToByteArray("T");
		//System.out.println(fakehdd.length);
		testhdd.SET(fakehdd, 1024000000, fakehdd.length);
		System.out.println(test.byteArrayToString(testhdd.GET(1024000000, fakehdd.length)));

		//byte[] initramfs = new byte[1];
		//initramfs[0] = 0;
		//CPU.setCache(0, initramfs);
		//Process GUI = new Process(0, graphicalUserInterface.priority);
		
		
		
		//MemTest testmem = new MemTest(RAM, GUI);
		//File tests = new File("test.txt", GUI);
		//CPU.cycle();
	}

}
