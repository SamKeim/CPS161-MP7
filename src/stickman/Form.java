package stickman;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Form {
	private int x, y, x2, y2;

	public abstract void draw(Graphics g);

	public void setColor(Graphics g) {
		g.setColor(Color.black);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public int getX2() {
		return x2;
	}

	public int getY2() {
		return y2;
	}
	public Form(int x, int y, int x2, int y2) {
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
	}
}

class Rectangle extends Form {
	public Rectangle(int x, int y, int x2, int y2) {
		super(x, y, x2, y2);
	}

	public void draw(Graphics g) {
		int width = getX2() - getX();
		int height = getY2() - getY();
		setColor(g);
		g.fillRect(getX(), getY(), width, height);
	}
}

class Oval extends Form {
	public Oval(int x, int y, int x2, int y2) {
		super(x, y, x2, y2);
	}

	public void draw(Graphics g) {
		int width = getX2() - getX();
		int height = getY2() - getY();
		setColor(g);
		g.drawOval(getX(), getY(), width, height);
	}
}

class Line extends Form{
	public Line(int x, int y, int x2, int y2) {
		super(x, y, x2, y2);
	}
	public void draw(Graphics g) {
		setColor(g);
		g.drawLine(getX(), getY(), getX2(), getY2());
	}
}
