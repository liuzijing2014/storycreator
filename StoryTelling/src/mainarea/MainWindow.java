package mainarea;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JMenuItem charpter;
	private JMenuItem read;
	private JPanel workingArea;
	
	static private Vector<CharpterPanel> allCharpters;
	
	MainWindow(){
		super("StoryCreator");
		initilize();
		CreateGUI();
		AddActions();
		setSize(new Dimension(960, 640));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void initilize(){
		allCharpters = new Vector<CharpterPanel>();
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
//				String name = JOptionPane.showInputDialog(null,"Please enter charpter name","Charpter ",JOptionPane.PLAIN_MESSAGE);
//				if(name == null) return;
//				CharpterPanel piece = new CharpterPanel(name, MainWindow.this);
//				allCharpters.add(piece);
//				workingArea.add(piece);
//				workingArea.revalidate();
//				workingArea.repaint();
				showConnectionDialog();
			}		
		});
	}
	
	public static Vector<CharpterPanel> getAllCharpters(){
		return allCharpters;
	}
	

	public static void showConnectionDialog() {
		JDialog mainPanel = new JDialog();
		mainPanel.setTitle("Ceate New Connection");
		mainPanel.setModal(true);
		mainPanel.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		JPanel inputPanel = new JPanel();
		JLabel promptLabel = new JLabel("Connect to");
		Border emptyBorder = BorderFactory.createEmptyBorder(0, 10, 0, 0);
		promptLabel.setBorder(emptyBorder);
		inputPanel.setLayout(new GridBagLayout());

		GridBagConstraints d = new GridBagConstraints();
		d.fill = GridBagConstraints.HORIZONTAL;
		d.gridx = 0;
		d.gridy = 0;
		d.ipadx = 30;
		d.ipady = 10;
		inputPanel.add(promptLabel, d);
		List<CharpterPanel> list = new ArrayList<CharpterPanel>();
		for (CharpterPanel cp : allCharpters) {
			list.add(cp);
		}
		CharpterPanel[] charpterList = list.toArray(new CharpterPanel[list.size()]);
		JComboBox<CharpterPanel> charpterBox = new JComboBox<CharpterPanel>(charpterList);
		
		d.gridx = 1;
		d.gridy = 0;
		JLabel jl = new JLabel("other charpters:");
		inputPanel.add(jl, d);
		d.gridx = 2;
		d.gridy = 0;
		inputPanel.add(charpterBox, d);

		JLabel desLabel = new JLabel("Description: ");
		emptyBorder = BorderFactory.createEmptyBorder(0, 10, 0, 0);
		desLabel.setBorder(emptyBorder);
		JTextField desField = new JTextField(15);
		d.gridx = 0;
		d.gridy = 1;
		inputPanel.add(desLabel, d);
		d.gridx = 1;
		d.gridy = 1;
		d.gridwidth = 4;
		inputPanel.add(desField, d);

		JPanel bottomPanel = new JPanel();
		JButton confirmButton = new JButton("Confirm");
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		emptyBorder = BorderFactory.createEmptyBorder(0, 0, 10, 0);
		bottomPanel.setBorder(emptyBorder);
		mainPanel.getRootPane().setDefaultButton(confirmButton);
		bottomPanel.add(confirmButton);

		mainPanel.setLayout(new BoxLayout(mainPanel.getContentPane(), BoxLayout.Y_AXIS));
		inputPanel.setBackground(Color.WHITE);
		mainPanel.add(inputPanel);
		bottomPanel.setBackground(Color.WHITE);
		mainPanel.add(bottomPanel);
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setMinimumSize(new Dimension(380, 200));
		mainPanel.setMaximumSize(new Dimension(380, 200));
		
		mainPanel.setLocationRelativeTo(null);
		mainPanel.setVisible(true);
	}
	
	public static void main(String [] args){
		new MainWindow();
	}

}
