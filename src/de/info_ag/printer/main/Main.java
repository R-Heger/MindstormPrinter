package de.info_ag.printer.main;

import de.info_ag.printer.motor.MotorManager;
import de.info_ag.printer.shape.Point;
import de.info_ag.printer.shape.PrintShape;
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
		
//		motorManager.print(shapeBuilder.createTestPicture());		
	}

}
