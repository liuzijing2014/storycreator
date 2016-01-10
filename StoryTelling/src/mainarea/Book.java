package mainarea;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Book extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel container;
	
	Book(CharpterPanel mCharpterPanel){
		super("Reading!");
		createGUI(mCharpterPanel);
		setSize(new Dimension(720, 640));
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void createGUI(CharpterPanel mCharpterPanel) {
		// TODO Auto-generated method stub
		container = new JPanel();
		container.setBackground(Color.WHITE);
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		JScrollPane outterPanel = new JScrollPane();
		outterPanel.setPreferredSize(new Dimension(720, 640));
		outterPanel.setOpaque(false);
		outterPanel.getViewport().setView(container);
		outterPanel.setBackground(Color.DARK_GRAY);
		add(outterPanel);
		
		container.add(new Page(mCharpterPanel, this));
	}
	
	public void addPage(CharpterPanel nextCharpterPanel){
		container.add(new Page(nextCharpterPanel, this));
	}
	
	public static void main(String [] args){
		new Book(new CharpterPanel("dsadas"));
	}

}
