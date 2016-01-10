package mainarea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import mainarea.EditArea.ConnectInfor;

public class Page extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private CharpterPanel mCharpterPanel;
	private Book mBook;
	private final Font mFont;
	
	Page(CharpterPanel mcCharpterPanel, Book mBook, String font){
		super();
		mFont = new Font(font, Font.PLAIN, 16);
		this.mCharpterPanel = mcCharpterPanel;
		this.mBook = mBook;
		createGUI();
		setPreferredSize(new Dimension(640, 640));
	}

	private void createGUI() {
		JLabel title = new JLabel(mCharpterPanel.toString()){
			private static final long serialVersionUID = 1L;

			protected void paintComponent(Graphics g) {
	            try {
					g.drawImage(ImageIO.read(Page.class.getResource("/resources/Book.png")), 0, 0, getWidth(), getHeight(), null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            super.paintComponent(g);
	        }
		};
		title.setFont(mFont);
		title.setPreferredSize(new Dimension(640, 50));
		title.setHorizontalAlignment(JLabel.CENTER);
		
		JTextArea text = new JTextArea(mCharpterPanel.getContent()){

			private static final long serialVersionUID = 1L; 
	        protected void paintComponent(Graphics g) {
				try {
					g.drawImage(ImageIO.read(Page.class.getResource("/resources/Book.png")), 0, 0, getWidth(), getHeight(), null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            super.paintComponent(g);
	        }
		};
		text.setFont(mFont);
		text.setBackground(new Color(1f,1f,1f,0.5f));
		text.setLineWrap(true);
		text.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(text);
		setLayout(new BorderLayout());
		add(title, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		
		JPanel bottomPanel = new JPanel(){
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
			    super.paintComponent(g); // paint the background image and scale it to fill the entire space
				try {
					g.drawImage(ImageIO.read(Page.class.getResource("/resources/Book.png")), 0, 0, getWidth(), getHeight(), null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		bottomPanel.setPreferredSize(new Dimension(640, 60));
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		for(ConnectInfor ci: mCharpterPanel.getAllConnectInfor()){
			JButton button = new JButton(ci.description);
			button.setFont(mFont);
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
