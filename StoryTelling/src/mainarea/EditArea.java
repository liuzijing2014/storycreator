package mainarea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;

//import library.ImageLibrary;

public class EditArea extends JFrame{

	private static final long serialVersionUID = -3998998610186381273L;
	
	private JTextField nameField;
	private JTextArea edit;
	private Cursor cursor;
	private JLabel nameLabel;
	private JLabel chapName;
	private JButton addSmth;
	
	private DefaultTableModel tableModel;
	private Vector<ConnectInfor> allConnected;
	
	public EditArea(JLabel label) {
		this.setMaximumSize(new Dimension(720,480));
		this.setMinimumSize(new Dimension(720,480));
		chapName = label;
		allConnected = new Vector<ConnectInfor>();
		setLayout(new BorderLayout());
		initialization();
		edit.setCursor(cursor);
		setLocationRelativeTo(null);
	}
	
	private void initialization() {
		nameLabel = new JLabel("Chapter Name: ");
		nameField = new JTextField(chapName.getText());
		nameField.setBackground(new Color(240, 251, 255));
		nameField.addCaretListener(new CaretListener(){

			@Override
			public void caretUpdate(CaretEvent e) {
				// TODO Auto-generated method stub
				String temp = nameField.getText();
				if(temp != null && temp != ""){
					chapName.setText(temp);
				}
			}
			
		});
		nameField.setBackground(Color.lightGray);
		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.setBackground(new Color(255, 247, 240));
		topPanel.setBorder(new EmptyBorder(0,5,0,0));
		topPanel.add(nameLabel, BorderLayout.WEST);
		topPanel.add(nameField, BorderLayout.CENTER);
		
		//JPanel centerPanel = new JPanel(new GridLayout(2,1));
		
		edit = new JTextArea("Type in the Contents...");
		edit.setLineWrap(true);
		edit.setBackground(new Color(255, 255, 240));
		JScrollPane scrollPane = new JScrollPane(edit);
		JPanel bottomPanel = new JPanel(new BorderLayout());
		bottomPanel.setPreferredSize(new Dimension(720, 120));
		bottomPanel.setBackground(new Color(255, 247, 240));
		
		addSmth = new JButton("+");
		addSmth.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showConnectionDialog();
			}
		});
		bottomPanel.add(addSmth, BorderLayout.EAST);
		
		String [] columnNames = {"Button Description", "Button Information"};
		tableModel = new DefaultTableModel(columnNames, 0) {
			private static final long serialVersionUID = -59423502301006168L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JTable table1 = new JTable(tableModel);
		table1.setGridColor(Color.BLACK);
		JScrollPane jsp = new JScrollPane(table1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		bottomPanel.add(jsp, BorderLayout.CENTER);
		bottomPanel.setBorder(new EmptyBorder(5,5,5,5));
		
		add(topPanel, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
	}
	
	public void showConnectionDialog() {
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
		for (CharpterPanel cp : MainWindow.getAllCharpters()) {
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
				ConnectInfor tempInfor = new ConnectInfor();
				tempInfor.next = (CharpterPanel) charpterBox.getSelectedItem();
				tempInfor.description = desField.getText();
				allConnected.add(tempInfor);
				tableModel.addRow(
						new Object[] { tempInfor.next, tempInfor.description });
				mainPanel.dispose();
				MainWindow.refresh();
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
		mainPanel.setMinimumSize(new Dimension(420, 200));
		mainPanel.setMaximumSize(new Dimension(420, 200));
		
		mainPanel.setLocationRelativeTo(null);
		mainPanel.setVisible(true);
	}
	
	public Vector<CharpterPanel> getAllConnnected(){
		Vector<CharpterPanel> results = new Vector<CharpterPanel>();
		for(ConnectInfor cInfor: allConnected){
			results.add(cInfor.next);
		}
		return results;
	}
	
	public Vector<ConnectInfor> getAllConnectInfor(){
		return allConnected;
	}
	
	public String getContent(){
		return edit.getText();
	}
	
	class ConnectInfor{
		public CharpterPanel next = null;
		public String description = null;
	}
}