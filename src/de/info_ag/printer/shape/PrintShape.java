package de.info_ag.printer.shape;

import java.util.LinkedList;

public class PrintShape {
	private LinkedList<ShapePart> parts;
	
	private Point startPoint;
	private Point end;

	public PrintShape(){
		this(0, 0);		
	}
	
	public PrintShape(int startX, int startY) {
		this(new Point(startX, startY));			
	}		

	public PrintShape(Point startPoint) {
		parts = new LinkedList<ShapePart>();
		this.startPoint = startPoint;
	}
	
	public void attachShapePart(int xParameter, int yParameter, boolean isPrinted) {
		parts.add(new ShapePart(xParameter, yParameter, isPrinted));
		end.setXCoordinate(end.getXCoordinate() + xParameter );
		end.setYCoordinate(end.getYCoordinate() + yParameter );
	}
	
	
	 
	public void attachPrintShape(PrintShape newShape){
		int newX = newShape.getStartPoint().getXCoordinate() - end.getXCoordinate();
		int newY = newShape.getStartPoint().getYCoordinate() - end.getYCoordinate();
		end.setXCoordinate(newShape.getStartPoint().getXCoordinate() + newShape.getEnd().getXCoordinate());
		end.setYCoordinate(newShape.getStartPoint().getYCoordinate() + newShape.getEnd().getXCoordinate());
		attachShapePart(newX, newY, false);
		parts.addAll(newShape.getParts());
		
	}
	
	
	public void scale(double scale){
		end.setXCoordinate((int) (end.getXCoordinate()*scale));
		end.setYCoordinate((int) (end.getYCoordinate()*scale));
		for(int index = 0; index < parts.size(); ++index){
			parts.get(index).setXParameter((int) (parts.get(index).getXParameter() * scale));
			parts.get(index).setYParameter((int) (parts.get(index).getYParameter() * scale));
		}	
		
	}
	
	public Point getStartPoint(){
		return startPoint;
	}
	
	public Point getEnd(){
		return end;
	}
	
	public LinkedList<ShapePart> getParts(){
		return parts;
	}
	}
