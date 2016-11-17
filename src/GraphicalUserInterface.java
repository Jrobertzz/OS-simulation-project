import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*; 

/*
 * the graphical user interface and embedded commandline
 * utilizes swing
 */
public class GraphicalUserInterface {
	public int priority = 10;
	public GraphicalUserInterface(){
		frame();
	}
	
	//set up swing
	public static void frame(){
		JFrame frame = new JFrame("HAL OS");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel content = new JPanel();
		content.setPreferredSize(new Dimension(1280, 960));
		frame.getContentPane().add(content, BorderLayout.CENTER);
		
		JTextField command_pane = new JTextField();
		command_pane.setBackground(java.awt.Color.black);
		command_pane.setForeground(java.awt.Color.green);
		//command_pane.
		//frame.add(command_pane, BorderLayout.PAGE_END);
		frame.add(command_pane, BorderLayout.PAGE_END);

		frame.pack();
		frame.setVisible(true);
	}
	
	//graphical component, ie resource utilization
	public static void gui(){
		
	}
	
	//command line interface
	public static void cli(){
		
	}
}
