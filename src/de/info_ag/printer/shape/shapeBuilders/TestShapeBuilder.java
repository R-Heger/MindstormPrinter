package de.info_ag.printer.shape.shapeBuilders;

import de.info_ag.printer.shape.Point;
import de.info_ag.printer.shape.PrintShape;

public class TestShapeBuilder extends PrintShapeBuilder {
	
	public static PrintShape createTestPicture1() {
		PrintShape test = new PrintShape();
		test.attachPrintShape(GeometryShapeBuilder.createSquareShape(80, new Point(0, 0)));
		test.attachPrintShape(createDiagonals());

		test.attachPrintShape(GeometryShapeBuilder.createPeak(30, 60, 1, new Point(0, 10)));
		test.attachPrintShape(GeometryShapeBuilder.createPeak(15, 60, 1, new Point(0, 10)));

		test.attachPrintShape(GeometryShapeBuilder.createPeak(30, 60, 2, new Point(70, 0)));
		test.attachPrintShape(GeometryShapeBuilder.createPeak(15, 60, 2, new Point(70, 0)));

		test.attachPrintShape(GeometryShapeBuilder.createPeak(30, 60, 3, new Point(80, 70)));
		test.attachPrintShape(GeometryShapeBuilder.createPeak(15, 60, 3, new Point(80, 70)));

		test.attachPrintShape(GeometryShapeBuilder.createPeak(30, 60, 4, new Point(10, 80)));
		test.attachPrintShape(GeometryShapeBuilder.createPeak(15, 60, 4, new Point(10, 80)));
		return test;
	}
	
	private static PrintShape createDiagonals() {
		PrintShape diags = new PrintShape();
		diags.attachShapePart(80, 80, true);
		diags.attachShapePart(0, -80, false);
		diags.attachShapePart(-80, 80, true);
		return diags;
	}
	
	public static PrintShape createTestPicture2() {
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

}
