package de.info_ag.printer.shape;

import java.util.LinkedList;

public class PrintShape {
		LinkedList<ShapePart> parts;
		
		private Point startPoint;

		public PrintShape(int startX, int startY) {
			parts = new LinkedList<ShapePart>();
			startPoint.setXCoordinate(startX);
			startPoint.setYCoordinate(startY);
		}
		
		public PrintShape(){
			this(0, 0);		
		}

		public void attachShapePart(int xParameter, int yParameter, boolean isPrinted) {
			parts.add(new ShapePart(xParameter, yParameter, isPrinted));
		}
		
		public void attachPrintShape(PrintShape newShape){
			//parts.attachShapePart(newShape.startPoint.getXCoordinate(), newShape.startPoint.getYCoordinate(), false);
			parts.addAll(newShape.parts);
		}
		
		public void scale(int scale){
			
		}
	}
