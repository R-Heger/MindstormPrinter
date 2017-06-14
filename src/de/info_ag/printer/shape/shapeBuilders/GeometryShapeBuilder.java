package de.info_ag.printer.shape.shapeBuilders;

import de.info_ag.printer.shape.Point;
import de.info_ag.printer.shape.PrintShape;

public class GeometryShapeBuilder extends PrintShapeBuilder {

	public static PrintShape createSquareShape(int height, Point start) {
		PrintShape square = new PrintShape(start);

		for (int i = 0; i < 4; ++i) {
			square.attachShapePart(height * ((i + 1) % 2) * (i < 2 ? 1 : -1), height * (i % 2) * (i < 2 ? 1 : -1),
					true);
		}

		return square;
	}

	public static PrintShape createPolygonShape(int sideCount, int sideLength, Point start) {

		if (sideCount < 3) {
			System.out.println("The least possible amount of sides is 3");
			return null;
		}

		PrintShape polygon = new PrintShape(start);

		double angle = 180 - ((sideCount - 2) * 180) / sideCount;

		for (int i = 1; i <= sideCount; ++i) {
			polygon.attachShapePart((int) (sideLength * Math.cos(angle * i / 180 * Math.PI)),
					(int) (sideLength * Math.sin(angle * i / 180 * Math.PI)), true);
		}

		return polygon;
	}
	
	/*
	 * to test...
	 */
//		public PrintShape createPolygonShape (int sideCount, int sideLength, Point start){
//			int smallestX = 0;
//			if(sideCount < 3){
//				System.out.println("The least possible amount of sides is 3");	
//				return null;
//			}
//			
//			PrintShape polygon = new PrintShape(start);
//			
//			double angle = 180 - ((sideCount-2)*180)/sideCount;
//			
//			for(int i=1; i<=sideCount; ++i){
//				int newX = (int) (sideLength*Math.cos(angle*i/180*Math.PI));
//				polygon.attachShapePart(newX, (int) (sideLength*Math.sin(angle*i/180*Math.PI)), true);
//				if(newX+smallestX<smallestX){
//					smallestX+=newX;
//				}
//			}
//			
//			polygon.setStartingPoint(new Point(smallestX, 0));
//			
//			return polygon;
	//   }
	
	public static PrintShape createPeak(int hight, int width, int orientation, Point start) {
		PrintShape peak = new PrintShape(start);

		switch (orientation) {
		case 1:
			peak.attachShapePart(hight, width / 2, true);
			peak.attachShapePart(-hight, width / 2, true);
			break;
		case 2:
			peak.attachShapePart(-width / 2, hight, true);
			peak.attachShapePart(-width / 2, -hight, true);
			break;
		case 3:
			peak.attachShapePart(-hight, -width / 2, true);
			peak.attachShapePart(hight, -width / 2, true);
			break;
		case 4:
			peak.attachShapePart(width / 2, -hight, true);
			peak.attachShapePart(width / 2, hight, true);
			break;
		default:
			System.err.println("Incorrect orientation!");
		}

		return peak;
	}
}
