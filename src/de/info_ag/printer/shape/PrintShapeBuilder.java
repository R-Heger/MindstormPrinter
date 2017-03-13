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
	
	
	public PrintShape createTestPicture(){
		PrintShape test = new PrintShape();
		test.attachPrintShape(createSquareShape(80, new Point(0,0)));
		test.attachPrintShape(createDiagonals());
		
		test.attachPrintShape(createPeak(30, 60, 1, new Point(0,10)));
		test.attachPrintShape(createPeak(15, 60, 1, new Point(0,10)));
		
		test.attachPrintShape(createPeak(30, 60, 2, new Point(70,0)));
		test.attachPrintShape(createPeak(15, 60, 2, new Point(70,0)));
		
		test.attachPrintShape(createPeak(30, 60, 3, new Point(80,70)));
		test.attachPrintShape(createPeak(15, 60, 3, new Point(80,70)));
		
		test.attachPrintShape(createPeak(30, 60, 4, new Point(10,80)));
		test.attachPrintShape(createPeak(15, 60, 4, new Point(10,80)));
		return test;
	}
	
	public PrintShape createDiagonals(){
		PrintShape diags = new PrintShape();
		diags.attachShapePart(80, 80, true);
		diags.attachShapePart(0, -80, false);
		diags.attachShapePart(-80, 80, true);
		return diags;
	}
	
	public PrintShape createPeak(int hight, int width, int orientation, Point start){
		PrintShape peak = new PrintShape(start);
		
		switch(orientation){
		case 1:
			peak.attachShapePart(hight, width/2, true);
			peak.attachShapePart(-hight, width/2, true);
		break;
		case 2:
			peak.attachShapePart(-width/2, hight, true);
			peak.attachShapePart(-width/2, -hight, true);
		break;
		case 3:
			peak.attachShapePart(-hight, -width/2, true);
			peak.attachShapePart(hight, -width/2, true);
		break;
		case 4:
			peak.attachShapePart(width/2, -hight, true);
			peak.attachShapePart(width/2, hight, true);
		break;
		default:
			System.out.println("Incorrect orientation!");
		}
		
		return peak;
	}
}
