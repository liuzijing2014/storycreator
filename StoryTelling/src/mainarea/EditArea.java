package mainarea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//import library.ImageLibrary;

public class EditArea extends JFrame{

	private static final long serialVersionUID = -3998998610186381273L;
	
	private JTextField nameField;
	private JTextArea edit;
	private Cursor cursor;
	private JLabel nameLabel;
	
	public EditArea() {
		this.setMaximumSize(new Dimension(720,480));
		this.setMinimumSize(new Dimension(720,480));
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
		nameField = new JTextField();
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
		nameField.setBackground(Color.GRAY);
		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.add(nameLabel, BorderLayout.WEST);
		topPanel.add(nameField, BorderLayout.CENTER);
		
		
		
		edit = new JTextArea();
		add(topPanel, BorderLayout.NORTH);
		add(edit, BorderLayout.CENTER);
	}
	
	private void addFunctionality() {
		
	}
	
	public static void main(String [] args) {
		new EditArea();
		
	}
}

