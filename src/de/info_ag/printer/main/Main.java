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
		
//		motorManager.print(shapeBuilder.createSquareShape(40, new Point(20,20)));
		motorManager.print(shapeBuilder.createSquareShape(80, new Point(0,0)));
//		motorManager.print(shapeBuilder.createTestPicture());
	}

}
