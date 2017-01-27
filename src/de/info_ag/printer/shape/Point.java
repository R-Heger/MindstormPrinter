package de.info_ag.printer.shape;

public class Point {
	private int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point() {
		this(0, 0);
	}

	public int getXCoordinate() {
		return x;
	}

	public void setXCoordinate(int x) {
		this.x = x;
	}

	public int getYCoordinate() {
		return y;
	}

	public void setYCoordinate(int y) {
		this.y = y;
	}

}
