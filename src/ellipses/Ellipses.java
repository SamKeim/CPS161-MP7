package ellipses;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Ellipses extends JFrame {
	private static final long serialVersionUID = 1L;
	static int i = 0;
	static int x = 0;
	static int y = 0;
	static int w, h;
	Color color;
	
	public Ellipses(int width, int height) {
		super("Ellipses");
		setSize(width, height);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g) {
		Dimension d = getSize();
		g.setColor(Color.white);
		g.fillRect(0, 0, d.width, d.height);
		w = d.width;
		h = d.height;
		while(w > 0 && h > 0) {
			paintEllipse(g);
		}
	}
	

	public void paintEllipse(Graphics g) {
		color = (i++ % 2 == 0) ? Color.blue : Color.red;
		g.setColor(color);
		g.fillOval(x, y, w, h);
		x += 5;
		y += 5; 
		w -= 10;
		h -= 10;
	}
	
	public static void main(String[] args) {
		Ellipses e = new Ellipses(700, 800);
	}
}
