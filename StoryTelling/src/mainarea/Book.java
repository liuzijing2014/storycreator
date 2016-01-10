package mainarea;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Book extends JFrame{
	
	Book(){
		super("Reading!");
		initialize();
		createGUI();
		setSize(new Dimension(720, 640));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void initialize() {
		// TODO Auto-generated method stub
		
	}
	
	private void createGUI() {
		// TODO Auto-generated method stub
		JPanel container = new JPanel();
		container.setBackground(Color.WHITE);
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		JScrollPane outterPanel = new JScrollPane();
		outterPanel.setPreferredSize(new Dimension(720, 640));
		outterPanel.setOpaque(false);
		outterPanel.getViewport().setView(container);
		outterPanel.setBackground(Color.DARK_GRAY);
		add(outterPanel);
		
		container.add(new Page());
	}
	
	public static void main(String [] args){
		new Book();
	}

}
