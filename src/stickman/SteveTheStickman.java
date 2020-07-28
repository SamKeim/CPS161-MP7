package stickman;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class SteveTheStickman extends JFrame {
	
	private static final long serialVersionUID = 1L;
	List<Form> formArr = drawSteve();
	
	public void addForm(Form f) {
		formArr.add(f);
		repaint();
	}
	
	public SteveTheStickman() {
		super("Hello, my name is Steve!");
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g) {
		Dimension d = getSize();
		g.setColor(Color.white);
		g.fillRect(0, 0, d.width, d.height);
		for(Form f : formArr) {
			f.draw(g);
		}
	}
	
	public List<Form> drawSteve(){
		List<Form> steve = new ArrayList<Form>();
		// add body
		steve.add(
				new Rectangle(207, 214, 288, 404)
				);
		
		// add legs
		steve.add(
				new Line(219, 405, 184, 502)
				);
		steve.add(
				new Line(281, 405, 316, 502)
				);
		
		// add arms
		steve.add(
				new Line(206, 257, 109, 214)
				);
		steve.add(
				new Line(288, 257, 385, 214)
				);
		
		// add neck and head
		steve.add(
				new Rectangle(236, 192, 261, 214)
				);
		steve.add(
				new Oval(190, 81, 305, 192)
				);
				
		// add hat
		steve.add(
				new Rectangle(185, 81, 303, 93)
				);
		steve.add(
				new Rectangle(219, 41, 273, 81)
				);
		
		// add face
		steve.add(
				new Oval(222, 154, 268, 162)
				);
		steve.add(
				new Oval(217, 117, 230, 130)
				);
		steve.add(
				new Oval(260, 117, 273, 130)
				);
		
		
		return steve;
	}
	
	public static void main(String[] args) {
		SteveTheStickman steve = new SteveTheStickman();
	}
	

}
