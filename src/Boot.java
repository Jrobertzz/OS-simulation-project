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
		GraphicalUserInterface graphicalUserInterface = new GraphicalUserInterface();
		Process GUI = new Process(0, graphicalUserInterface.priority);
	}

}
