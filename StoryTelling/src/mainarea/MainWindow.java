package mainarea;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JMenuItem charpter;
	private JMenuItem read;
	private JPanel workingArea;
	
	MainWindow(){
		super("StoryCreator");
		CreateGUI();
		AddActions();
		setSize(new Dimension(960, 640));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void CreateGUI(){
		
		JMenuBar jmb = new JMenuBar(); 
		JMenu add = new JMenu("New");
		charpter = new JMenuItem("Charpter");
		add.add(charpter);
		jmb.add(add);
		setJMenuBar(jmb);
		
		workingArea = new JPanel();
		workingArea.setLayout(null);
		add(workingArea);
	}
	
	private void AddActions(){
		charpter.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				CharpterPanel piece = new CharpterPanel("testing!!!!!!!!!!!!");
				workingArea.add(piece);
				workingArea.revalidate();
				workingArea.repaint();
			}		
		});
	}

	
	public static void main(String [] args){
		new MainWindow();
	}
}
