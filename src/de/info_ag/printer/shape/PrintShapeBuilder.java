package de.info_ag.printer.shape;

public class PrintShapeBuilder {

	public PrintShape createSquareShape(int size, Point start) {
		PrintShape square = new PrintShape(start);

		square.attachShapePart(size, 0, true);
		square.attachShapePart(0, size, true);
		square.attachShapePart(-size, 0, true);
		square.attachShapePart(0, -size, true);

		return square;
	}

	/*
	 * von Constantin und Jonathan 
	 */
	public PrintShape createSquare(int height, Point start){
		PrintShape square = new PrintShape(start);
		
		for(int i = 0; i < 4; ++i){
			square.attachShapePart(height*((i+1)%2)*(i<2?1:-1), height*(i%2)*(i<2?1:-1), true);
		}
		
		return square;
	}

	/*
	 * von Samuel
	 */
	public PrintShape createPolygonShape (int sideCount, int sideLength, Point start){
		
		if(sideCount < 3){
			System.out.println("The least possible amount of sides is 3");	
			return null;
		}
		
		PrintShape polygon = new PrintShape(start);
		
		double angle = 180 - ((sideCount-2)*180)/sideCount;
		
		for(int i=1; i<=sideCount; ++i){
			polygon.attachShapePart((int) (sideLength*Math.cos(angle*i/180*Math.PI)),
										(int) (sideLength*Math.sin(angle*i/180*Math.PI)), true);
		}
		
		return polygon;
}

	/*
	 * von Tobias
	 */
	public PrintShape createTestImage() {
		PrintShape test = new PrintShape(new Point(0, 0));
		for (int i = 0; i < 16; i++) {
			switch (i % 4) {
			case 0:
				test.attachShapePart(80 - 5 * i, 0, true);
				break;
			case 1:
				test.attachShapePart(0, 80 - 5 * i, true);
				break;
			case 2:
				test.attachShapePart((80 - 5 * i) * (-1), 0, true);
				break;
			case 3:
				test.attachShapePart(0, (80 - 5 * i) * (-1), true);
				break;
			}
		}
		return test;
	}

	public PrintShape createTestPicture() {
		PrintShape test = new PrintShape();
		test.attachPrintShape(createSquareShape(80, new Point(0, 0)));
		test.attachPrintShape(createDiagonals());

		test.attachPrintShape(createPeak(30, 60, 1, new Point(0, 10)));
		test.attachPrintShape(createPeak(15, 60, 1, new Point(0, 10)));

		test.attachPrintShape(createPeak(30, 60, 2, new Point(70, 0)));
		test.attachPrintShape(createPeak(15, 60, 2, new Point(70, 0)));

		test.attachPrintShape(createPeak(30, 60, 3, new Point(80, 70)));
		test.attachPrintShape(createPeak(15, 60, 3, new Point(80, 70)));

		test.attachPrintShape(createPeak(30, 60, 4, new Point(10, 80)));
		test.attachPrintShape(createPeak(15, 60, 4, new Point(10, 80)));
		return test;
	}

	public PrintShape createDiagonals() {
		PrintShape diags = new PrintShape();
		diags.attachShapePart(80, 80, true);
		diags.attachShapePart(0, -80, false);
		diags.attachShapePart(-80, 80, true);
		return diags;
	}

	public PrintShape createPeak(int hight, int width, int orientation, Point start) {
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
