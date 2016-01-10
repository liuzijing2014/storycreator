package mainarea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import mainarea.EditArea.ConnectInfor;

public class Page extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private CharpterPanel mCharpterPanel;
	private Book mBook;
	
	Page(CharpterPanel mcCharpterPanel, Book mBook){
		super();
		this.mCharpterPanel = mcCharpterPanel;
		this.mBook = mBook;
		createGUI();
		setPreferredSize(new Dimension(640, 640));
	}

	private void createGUI() {
		JTextArea text = new JTextArea(mCharpterPanel.getContent()){

			private static final long serialVersionUID = 1L; 
	        protected void paintComponent(Graphics g) {
	            g.drawImage(library.ImageLibrary.getImage("resources/Book.png"), 0, 0, getWidth(), getHeight(), null);
	            super.paintComponent(g);
	        }
		};
		text.setBackground(new Color(1f,1f,1f,0.5f));
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
					mBook.revalidate();
					mBook.repaint();
					button.setEnabled(false);
				}	
			});
			bottomPanel.add(button);
		}
		add(bottomPanel, BorderLayout.SOUTH);
	}
}
