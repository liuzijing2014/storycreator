package mainarea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

//import library.ImageLibrary;

public class EditArea extends JFrame{

	private static final long serialVersionUID = -3998998610186381273L;
	
	private JTextField nameField;
	private JTextArea edit;
	private Cursor cursor;
	private JLabel nameLabel;
	private String chapName;
	private JButton addSmth;
	
	public EditArea(String chapname) {
		this.setMaximumSize(new Dimension(720,480));
		this.setMinimumSize(new Dimension(720,480));
		chapName = chapname;
		Toolkit toolkit = Toolkit.getDefaultToolkit();
    	Image cursorImg;
		try {
			cursorImg = ImageIO.read(new File("/Users/hejie/Desktop/cursor2.png"));
			cursor = toolkit.createCustomCursor(cursorImg,new Point(0,0),"hand");
			setCursor(cursor);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setLayout(new BorderLayout());
		initialization();
		edit.setCursor(cursor);
		setLocationRelativeTo(null);
		//setUndecorated(true);
    	setVisible(true);
	}
	
	private void initialization() {
		nameLabel = new JLabel("Chapter Name: ");
		//nameLabel.setBackground(new Color(35, 152, 208));
		//nameLabel.setBorder(border);
		nameField = new JTextField(chapName);
		nameField.addKeyListener(new KeyAdapter() {
			 public void keyPressed(KeyEvent ke) {  // handler
			    if(ke.getKeyCode() == ke.VK_ESCAPE) {
			    	System.out.println("escaped ?");
			      	setVisible(false);
			    } 
			    else {
			    	System.out.println("not escaped");
			    }
			 } 
		});
		nameField.setBackground(Color.lightGray);
		JPanel topPanel = new JPanel(new BorderLayout());
		//topPanel.setBackground(new Color(35, 152, 208));
		topPanel.setBorder(new EmptyBorder(0,5,0,0));
		topPanel.add(nameLabel, BorderLayout.WEST);
		topPanel.add(nameField, BorderLayout.CENTER);
		
		JPanel centerPanel = new JPanel(new GridLayout(2,1));
		
		edit = new JTextArea();
		edit.setLineWrap(true);
		
		JPanel bottomPanel = new JPanel(new BorderLayout());
		
		addSmth = new JButton("+");
		bottomPanel.add(addSmth, BorderLayout.EAST);
		
		String [] columnNames = {"Button Description", "Button Information"};
		Object [][] data = { {"Null", "Null"} };
		JTable table1 = new JTable(data, columnNames);
		table1.setModel(dataModel);
		table1.setGridColor(Color.BLACK);
		JScrollPane jsp = new JScrollPane(table1);
		bottomPanel.add(jsp, BorderLayout.CENTER);
		//JTextArea new1 = new JTextArea();
		bottomPanel.setBorder(new EmptyBorder(5,5,5,5));
		add(topPanel, BorderLayout.NORTH);
		centerPanel.add(edit);
		centerPanel.add(bottomPanel);
		add(centerPanel);
	}
	
	private void addFunctionality() {
		
	}
	
	public static void main(String [] args) {
		new EditArea("LiuZijing shi sabi");
		
	}
	
	private final TableModel dataModel = new AbstractTableModel() {
		public boolean isCellEditable(int row, int col) { 
		    return true;
		}
		
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return 2;
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 2;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return null;
		}
	};
}

