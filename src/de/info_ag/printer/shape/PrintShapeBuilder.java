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
	
	
//TODO	
public PrintShape createPolygonShape (int sideCount, int sideLength, Point start){
		
		if(sideCount < 3){
			System.out.println("The least possible amount of sides is 3");	
			return null;
		}
		
		PrintShape polygon = new PrintShape(start);
		
		double angle = 180 - ((sideCount-2)*180)/sideCount;
		
		
		
		return polygon;
	}

}
