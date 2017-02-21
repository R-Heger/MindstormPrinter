package de.info_ag.printer.shape;

public class PrintShapeBuilder {
	
	public PrintShape createSquareShape(int size, Point start){
		PrintShape square = new PrintShape(start);
		
		square.attachShapePart(size, 0, true);
		square.attachShapePart(0, size, true);
		square.attachShapePart(-size, 0, true);
		square.attachShapePart(0, -size, true);
		
		return square;
	}

}
