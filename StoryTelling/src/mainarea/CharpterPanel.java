package mainarea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.MouseInputAdapter;

public class CharpterPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel text;
	private boolean click = false;
	
	public CharpterPanel(String display) {
		setLayout(new BorderLayout());
		setSize(new Dimension(120, 80));
		DragListener drag = new DragListener();
		addMouseListener(drag);
		addMouseMotionListener(drag);
		setBorder(new TitledBorder("Charpter"));
		text = new JLabel(display); 
		add(text);
		setBounds(10, 10, 90, 60);
	}
	
    public class DragListener extends MouseInputAdapter {
        Point location;
        MouseEvent pressed;

        public void mousePressed(MouseEvent me) {
            pressed = me;
        }
        
        public void mouseClicked(MouseEvent me){

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
