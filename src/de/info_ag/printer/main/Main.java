package de.info_ag.printer.main;

import de.info_ag.printer.motor.MotorManager;
import de.info_ag.printer.shape.Point;
import de.info_ag.printer.shape.PrintShapeBuilder;
import lejos.nxt.Button;

public class Main {
	
	private static MotorManager motorManager;
	private static PrintShapeBuilder shapeBuilder;
	
	
	public static void main(String[] args) {
		motorManager = new MotorManager();
		shapeBuilder = new PrintShapeBuilder();
		
		Button.waitForAnyPress();
//		motorManager.calibratePen();
		
//		motorManager.print(shapeBuilder.createSquare(70, new Point(5,5)));
//		motorManager.print(shapeBuilder.createTestImage());
		motorManager.print(shapeBuilder.createPolygonShape(6, 30, new Point(50,20)));
		
//		motorManager.print(shapeBuilder.createSquareShape(40, new Point(20,20)));
//		motorManager.print(shapeBuilder.createSquareShape(80, new Point(0,0)));
//		motorManager.print(shapeBuilder.createTestPicture());
	}

}
