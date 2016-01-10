package mainarea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import library.ImageLibrary;
import mainarea.EditArea.ConnectInfor;

public class Page extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private CharpterPanel mCharpterPanel;
	private Book mBook;
	
	Page(CharpterPanel mcCharpterPanel, Book mBook){
		super();
		this.mCharpterPanel = mcCharpterPanel;
		this.mBook = mBook;
		initialize();
		createGUI();
		setPreferredSize(new Dimension(640, 640));
	}
	
	private void initialize() {
		// TODO Auto-generated method stub
		
	}

	private void createGUI() {
		// TODO Auto-generated method stub
		JTextArea text = new JTextArea(mCharpterPanel.getContent()) {

			private static final long serialVersionUID = 1L;
			protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        Image mImage = ImageLibrary.getImage("resources/Book.png"); 
		        g.drawImage(mImage, 0, 0, getWidth(), getHeight(), null);
			}        
			
		};
		text.setLineWrap(true);
		text.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(text);
		setLayout(new BorderLayout());
		add(scrollPane);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		bottomPanel.setPreferredSize(new Dimension(640, 120));
		for(ConnectInfor ci: mCharpterPanel.getAllConnectInfor()){
			JButton button = new JButton(ci.description);
			button.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					mBook.addPage(ci.next);
				}	
			});
		}
		add(bottomPanel, BorderLayout.SOUTH);
	}
}
