package mainarea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Page extends JPanel {
	
	Page(){
		super();
		initialize();
		createGUI();
		setPreferredSize(new Dimension(640, 640));
	}
	
	private void initialize() {
		// TODO Auto-generated method stub
		
	}

	private void createGUI() {
		// TODO Auto-generated method stub
		JTextArea text = new JTextArea("dsadas");
		text.setLineWrap(true);
		text.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(text);
		setLayout(new BorderLayout());
		add(scrollPane);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		bottomPanel.setPreferredSize(new Dimension(640, 120));
		bottomPanel.add(new JButton("asdada"));
		add(bottomPanel, BorderLayout.SOUTH);
	}
}
