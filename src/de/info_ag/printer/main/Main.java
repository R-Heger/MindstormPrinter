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
//		motorManager.calibrate();
//		Button.waitForAnyPress();

//		motorManager.print(shapeBuilder.createSquareShape(4, new Point(2,2)));
		
//		motorManager.testArcs();
		motorManager.testPicture();
//		Button.waitForAnyPress();
//		motorManager.lift();
		
	}

}
