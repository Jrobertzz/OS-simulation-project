/*
 * main java class, initializes operating system simulation
 * 
 * created by Jrobertzz on 11/10/2016
 */
public class Boot {

	public static void main(String[] args) {
		Scheduler schedule = new Scheduler();
		Memory RAM = new Memory();
		CentralProcessingUnit CPU = new CentralProcessingUnit();
		GraphicalUserInterface GUI = new GraphicalUserInterface();
		PIDList PIDs = new PIDList();
		//Process GUI = new Process(0, graphicalUserInterface.priority);
		
		MemTest test = new MemTest(RAM, GUI);
		File tests = new File("test.tzt", GUI);
	}

}
