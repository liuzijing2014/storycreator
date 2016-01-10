package mainarea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputAdapter;

public class CharpterPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel text;
	//private MainWindow parent;
	
	private EditArea mEditArea;
	
	private final Color[] colorList = { Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY,
			Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW,
			Color.GREEN };
	private int colorIndex = 0;
	
	public CharpterPanel(String display) {
		//this.parent = parent;
		setLayout(new BorderLayout());
		setSize(new Dimension(120, 80));
		setBackground(Color.lightGray);
		DragListener drag = new DragListener();
		addMouseListener(drag);
		addMouseMotionListener(drag);
		setBorder(new LineBorder(colorList[colorIndex], 2));
		text = new JLabel(display); 
		add(text);
		setBounds(10, 10, 90, 60);
		
		mEditArea = new EditArea();
	}
	
   // @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
////        if(mEditArea.isConnected == true){
////        }
//        Point p = this.getLocationOnScreen();
//        
//        int x = (int) p.getX();
//        int y = (int) p.getY();
//        System.out.println(x);
//        System.out.println(y);
//        g.drawLine(x, y, 0, 0);
//    }
	
	public Vector<CharpterPanel> getAllConnected(){
		return mEditArea.getAllConnnected();
	}
	
    public class DragListener extends MouseInputAdapter {
        Point location;
        MouseEvent pressed;

        public void mousePressed(MouseEvent me) {
            pressed = me;
        }
        
        public void mouseClicked(MouseEvent me){
        	if(me.getClickCount() == 2){
        		
        	}
        	else if(me.getClickCount() == 1){
        		colorIndex = (colorIndex + 1) % 13;
        		setBorder(new LineBorder(colorList[colorIndex], 2));
        	}
        }

        public void mouseDragged(MouseEvent me) {
            Component component = me.getComponent();
            location = component.getLocation(location);
            int x = location.x - pressed.getX() + me.getX();
            int y = location.y - pressed.getY() + me.getY();
            component.setLocation(x, y);
            
        }
    }
}
