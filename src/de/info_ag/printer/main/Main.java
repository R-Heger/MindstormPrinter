package de.info_ag.printer.main;

import de.info_ag.printer.motor.MotorManager;
import lejos.nxt.Button;

public class Main {
	
	private static MotorManager motorManager;
	
	
	public static void main(String[] args) {
		motorManager = new MotorManager();
		
		Button.waitForAnyPress();
//		motorManager.calibrate();
		
		
//		motorManager.testPicture();
//		Button.waitForAnyPress();
//		motorManager.lift();
		
	}

}
