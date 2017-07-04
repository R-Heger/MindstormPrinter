package de.info_ag.printer.shape;

import java.util.LinkedList;

public class PrintShape2D {
	private LinkedList<ShapePart> parts;

	private Point startPoint;
	private Point end;

	public PrintShape2D() {
		this(0, 0);
	}

	public PrintShape2D(int startX, int startY) {
		this(new Point(startX, startY));
	}

	public PrintShape2D(Point startPoint) {
		parts = new LinkedList<ShapePart>();
		this.startPoint = startPoint;
		this.end = new Point(0, 0);
	}

	public void attachShapePart(double xParameter, double yParameter, boolean isPrinted) {
		attachShapePart((int) xParameter, (int) yParameter, isPrinted);
	}

	public void attachShapePart(int xParameter, int yParameter, boolean isPrinted) {
		parts.add(new ShapePart(xParameter, yParameter, isPrinted));
		end.setXCoordinate(end.getXCoordinate() + xParameter);
		end.setYCoordinate(end.getYCoordinate() + yParameter);
	}

	public void attachPrintShape(PrintShape2D newShape) {
		int newX = newShape.getStartPoint().getXCoordinate() - end.getXCoordinate();
		int newY = newShape.getStartPoint().getYCoordinate() - end.getYCoordinate();
		if (!(newX == 0 && newY == 0)) {
			attachShapePart(newX, newY, false);
		}
		end.setXCoordinate(newShape.getStartPoint().getXCoordinate() + newShape.getEnd().getXCoordinate());
		end.setYCoordinate(newShape.getStartPoint().getYCoordinate() + newShape.getEnd().getYCoordinate());

		parts.addAll(newShape.getParts());

	}

	public void scale(double scale) {
		end.setXCoordinate((int) (end.getXCoordinate() * scale));
		end.setYCoordinate((int) (end.getYCoordinate() * scale));
		for (int index = 0; index < parts.size(); ++index) {
			parts.get(index).setXParameter((int) (parts.get(index).getXParameter() * scale));
			parts.get(index).setYParameter((int) (parts.get(index).getYParameter() * scale));
		}

	}

	private double getAngle(int x, int y) {
		if (x == 0 && y > 0) {
			return Math.PI / 2;
		} else if (x == 0 && y < 0) {
			return Math.PI / 2 * 3;
		} else if (x < 0 && y == 0) {
			return Math.PI;
		} else if (x > 0 && y > 0) {
			return (Math.atan(Math.abs(y) / Math.abs(x)));
		} else if (x > 0 && y < 0) {
			return (2 * Math.PI - Math.atan(Math.abs(y) / Math.abs(x)));
		} else if (x < 0 && y > 0) {
			return (Math.PI - Math.atan(Math.abs(y) / Math.abs(x)));
		} else if (x < 0 && y < 0) {
			return (Math.PI + Math.atan(Math.abs(y) / Math.abs(x)));
		} else {
			return 0;
		}

	}

	private Point getMid() {
		int x = 0;
		int aktX = 0;
		int y = 0;
		int aktY = 0;
		for (ShapePart part : this.getParts()) {
			aktX += part.getXParameter();
			aktY += part.getYParameter();
			if (aktX > x) {
				x = aktX;
			}
			if (aktY > y) {
				y = aktY;
			}
		}

		return new Point((int) x / 2, (int) y / 2);
	}

	public PrintShape2D rotate(double angle) {
		angle = angle * Math.PI / 180;
		double l = 0;
		double a = 0;

		PrintShape2D rotated = new PrintShape2D();

		for (ShapePart part : this.getParts()) {
			l = Math.sqrt(Math.pow(part.getXParameter(), 2) + Math.pow(part.getYParameter(), 2));
			a = getAngle(part.getXParameter(), part.getYParameter());
			rotated.attachShapePart((int) (Math.cos(angle + a) * l), (int) (Math.sin(angle + a) * l), part.isPrinted());
		}

		Point mid = this.getMid();
		l = Math.sqrt(Math.pow(mid.getXCoordinate(), 2) + Math.pow(mid.getYCoordinate(), 2));
		a = getAngle(mid.getXCoordinate(), mid.getYCoordinate());
		rotated.startPoint.setXCoordinate(
				this.startPoint.getXCoordinate() + (((int) ((-1) * (Math.cos(angle + a) * l) + mid.getXCoordinate()))));
		rotated.startPoint.setYCoordinate(
				this.startPoint.getYCoordinate() - (((int) ((-1) * (Math.cos(angle + a) * l) + mid.getYCoordinate()))));

		return rotated;
	}

	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startingPoint) {
		startPoint = startingPoint;
	}

	public Point getEnd() {
		return end;
	}

	public LinkedList<ShapePart> getParts() {
		return parts;
	}
}
