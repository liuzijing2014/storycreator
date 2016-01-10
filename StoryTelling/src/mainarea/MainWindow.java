package mainarea;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JMenuItem charpter;
	private JMenuItem read;
	private static CustomPanel workingArea;
	

	
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
		charpter = new JMenuItem("Chapter");
		JMenu edit = new JMenu("Edit");
		read = new JMenuItem("Read");
		add.add(charpter);
		edit.add(read);
		jmb.add(add);
		jmb.add(edit);
		setJMenuBar(jmb);
		
		workingArea = new CustomPanel();
		workingArea.setLayout(null);
		workingArea.setBackground(new Color(244, 255, 240));
		add(workingArea);
	}
	
	private void AddActions(){
		charpter.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog(null,"Please enter chapter name","Chapter ",JOptionPane.PLAIN_MESSAGE);
				if(name == null) return;
				CharpterPanel piece = new CharpterPanel(name);
				allCharpters.add(piece);
				workingArea.add(piece);
				workingArea.revalidate();
				workingArea.repaint();
			}		
		});
		
		read.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object[] charpters = allCharpters.toArray(); 
			    CharpterPanel beginningCharpter = (CharpterPanel) JOptionPane.showInputDialog(null, 
			            "Which chapter would you want to start with?",
			            "Read",
			            JOptionPane.PLAIN_MESSAGE, 
			            null, 
			            charpters, 
			            charpters[0]);
			    new Book((CharpterPanel)beginningCharpter);
			}
		});
	}
	
	public static Vector<CharpterPanel> getAllCharpters(){
		return allCharpters;
	}
	
	public static void main(String [] args){
		new MainWindow();
	}
	
	
	class CustomPanel extends JPanel {
		
		private static final long serialVersionUID = 1L;

		protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
	//	        if(mEditArea.isConnected == true){
	//	        }
		        Point p = null;
		        for (CharpterPanel chap : allCharpters) {
		        	if(chap != null && !chap.getAllConnected().isEmpty()) {
			        	p = chap.getLocation();
			        	int x1 = (int) p.getX() + 120;
				        int y1 = (int) p.getY() + 40;
				        for(CharpterPanel otherChap : chap.getAllConnected()) {
					        p = otherChap.getLocation();
				        	int x2 = ((int) p.getX()) + 0;
					        int y2 = ((int) p.getY()) + 40;
					        drawArrowLine(g, x1, y1, x2, y2, 6, 6);
				        }
				        repaint();
				    }

		        }
		        
		       
		        }        

		 }
		
		 private void drawArrowLine(Graphics g, int x1, int y1, int x2, int y2, int d, int h){
		        int dx = x2 - x1, dy = y2 - y1;
		        double D = Math.sqrt(dx*dx + dy*dy);
		        double xm = D - d, xn = xm, ym = h, yn = -h, x;
		        double sin = dy/D, cos = dx/D;

		        x = xm*cos - ym*sin + x1;
		        ym = xm*sin + ym*cos + y1;
		        xm = x;

		        x = xn*cos - yn*sin + x1;
		        yn = xn*sin + yn*cos + y1;
		        xn = x;

		        int[] xpoints = {x2, (int) xm, (int) xn};
		        int[] ypoints = {y2, (int) ym, (int) yn};

		        ((Graphics2D) g).setStroke(new BasicStroke(2));
		        g.drawLine(x1, y1, x2, y2);
		        g.fillPolygon(xpoints, ypoints, 3);
		     }


	public static void refresh() {
		// TODO Auto-generated method stub
		workingArea.repaint();
	}

}
