import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*; 

/*
 * the graphical user interface and embedded commandline
 * utilizes swing
 * 
 * AUTHOR: Jrobertzz
 * 11/18/2016
 */

public class GraphicalUserInterface implements ActionListener{
	FlowLayout console_layout = new FlowLayout();
	protected JTextArea command_location;
	protected JTextField command_pane;
	protected JTextArea command_history;
	public int priority = 10;
	public GraphicalUserInterface(){
	frame();
	}
	
	//set up swing
	public void frame(){
		
		JFrame frame = new JFrame("HAL OS");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel content = new JPanel();
		content.setPreferredSize(new Dimension(1280, 960));
		frame.getContentPane().add(content, BorderLayout.CENTER);
		
		JPanel console = new JPanel();
		console.setLayout(new BoxLayout(console, BoxLayout.Y_AXIS));
		
		frame.add(console, BorderLayout.PAGE_END);

		command_location = new JTextArea("~/USER");
		command_location.setBackground(java.awt.Color.black);
		command_location.setForeground(java.awt.Color.green);
		command_location.setEditable(false);
		command_location.setBorder(null);
		
		console.add(command_location);

		command_history = new JTextArea();
		command_history.setColumns(100);
		command_history.setBorder(null);
		command_history.setBackground(java.awt.Color.black);
		command_history.setForeground(java.awt.Color.green);
		command_history.setEditable(false);
		JScrollPane scroll = new JScrollPane(command_history);
		scroll.setPreferredSize(new Dimension(1280, 100));
		scroll.setBorder(null);
		
		console.add(scroll);
		
		command_pane = new JTextField();
		command_pane.addActionListener(this);
		command_pane.setColumns(100);
		command_pane.setBorder(null);
		command_pane.setBackground(java.awt.Color.black);
		command_pane.setForeground(java.awt.Color.green);
		console.add(command_pane);

		frame.pack();
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent evt) {
        String text = command_pane.getText();
        command_history.append(text + "\n");
        command_history.selectAll();
        command_history.setCaretPosition(command_history.getDocument().getLength());
        command_pane.setText(null);

		Terminator(text);
    }
	

	public void Terminator(String text){
		String[] command = text.split("\\s+", 2);
		switch (command[0]){
			case "PROC":
				break;
			case "MEM":
				break;
			case "LOAD":
				break;
			case "EXE":
				break;
			case "RESET":
				break;
			case "EXIT":
				System.exit(0);
			case "print":
		        command_history.append(command[1] + "\n");
		        command_history.selectAll();
		        command_history.setCaretPosition(command_history.getDocument().getLength());
				Terminator(command[1]);
			default:break;
		}
	}
}
