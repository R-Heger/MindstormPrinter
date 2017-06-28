package de.info_ag.printer.shape;

import java.util.LinkedList;

public class PrintShape3D {
	private LinkedList<PrintShape2D> parts;
	private Point startPoint;
	private Point end;

	public PrintShape3D() {
		this(0, 0);
	}

	public PrintShape3D(int startX, int startY) {
		this(new Point(startX, startY));
	}

	public PrintShape3D(Point startPoint) {
		parts = new LinkedList<PrintShape2D>();
		this.startPoint = startPoint;
		this.end = new Point(0, 0);
	}

	public void attachLayer(PrintShape2D shape) {
		parts.add(shape);
	}

	public void scale(double scale) {
		end.setXCoordinate((int) (end.getXCoordinate() * scale));
		end.setYCoordinate((int) (end.getYCoordinate() * scale));
		for(int i = 0; i < parts.size(); ++i){
			parts.get(i).scale(scale);
		}
	}

	public Point getStartPoint() {
		return startPoint;
	}

	public Point getEnd() {
		return end;
	}

	public LinkedList<PrintShape2D> getParts() {
		return parts;
	}
}
