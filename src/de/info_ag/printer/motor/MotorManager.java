package de.info_ag.printer.motor;

import de.info_ag.printer.shape.PrintShape;
import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.util.Delay;

/**
 * The class manages the motor movements and interaction of the 3 axes for
 * printing
 *
 */
public class MotorManager {

	public static final double X_SPEED_CORRECTION = 0.58;
	public static final double Y_SPEED_CORRECTION = 1.0;
	public static final double Z_SPEED_CORRECTION = 1.0;

	public static final double X_DEGREE_PER_MILLIMETER = 87.8;
	public static final double Y_DEGREE_PER_MILLIMETER = 152.1; //145.94;
	public static final double Z_DEGREE_PER_MILLIMETER = 576.0;

	private MotorController xController;
	private MotorController yController;
	private MotorController zController;

	/**
	 * Inits the 3 MotorController for the 3 axes. Maps each axis a motor and a
	 * touch sensor
	 */
	public MotorManager() {
		xController = new MotorController(Motor.A, SensorPort.S2, false, X_DEGREE_PER_MILLIMETER, X_SPEED_CORRECTION);
		yController = new MotorController(Motor.B, SensorPort.S4, false, Y_DEGREE_PER_MILLIMETER, Y_SPEED_CORRECTION);
		zController = new MotorController(Motor.C, SensorPort.S1, false, Z_DEGREE_PER_MILLIMETER, Z_SPEED_CORRECTION);
	}

	/**
	 * Calibrates the axes to their Origin
	 */
	public void calibrate() {
		zController.driveAlone(2);
		xController.calibrate();
		yController.calibrate();
		yController.driveAlone(5);
		zController.calibrate();
	}

	/**
	 * @param controller
	 *            The Controller to calibrate
	 */
	public void calibrate(MotorController controller) {
		controller.calibrate();
	}

	/**
	 * @param shape
	 */
	public void print(PrintShape shape) {
		if(checkShape(shape)){
			// TODO print the shape
		} else {
			//TODO errorhandling
		}
	}
	
	public void lift(){
		zController.driveAlone(30);
	}
	
	private boolean checkShape(PrintShape printShape){
		//TODO
		return false;		
	}
	
	
	public void border(){
		calibrate();
		
		xController.driveAlone(80);
		yController.driveAlone(80);
		xController.driveAlone(-80);
		yController.driveAlone(-80);
	}
	
	public void testDiagonals(){
		calibrate();
		
		xController.drive(80,1);
		yController.driveAlone(80);
		
		calibrate();
		
		zController.driveAlone(2);
		yController.driveAlone(80);
		zController.calibrate();
		
		xController.drive(80,1);
		yController.driveAlone(-80);				
	}
	
	public void testArcs(){
		calibrate();
		
		zController.driveAlone(2);
		xController.driveAlone(10);
		zController.calibrate();
		
		xController.drive(30,1.0);
		yController.driveAlone(30);
		xController.drive(30,1.0);
		yController.driveAlone(-30);		
				
		yController.drive(15,0.5);
		xController.driveAlone(-30);
		yController.drive(-15,0.5);
		xController.driveAlone(-30);
		
		
		calibrate();
		
		zController.driveAlone(2);
		xController.driveAlone(80);
		yController.driveAlone(10);
		zController.calibrate();
		
		xController.drive(-30,1.0);
		yController.driveAlone(30);
		xController.drive(30,1.0);
		yController.driveAlone(30);		
				
		xController.drive(-15,0.5);
		yController.driveAlone(-30);
		xController.drive(15,0.5);
		yController.driveAlone(-30);
		
		calibrate();
		
		zController.driveAlone(2);
		xController.driveAlone(70);
		yController.driveAlone(80);
		zController.calibrate();
		
		xController.drive(-30,1.0);
		yController.driveAlone(-30);
		xController.drive(-30,1.0);
		yController.driveAlone(30);		
				
		yController.drive(-15,0.5);
		xController.driveAlone(30);
		yController.drive(15,0.5);
		xController.driveAlone(30);
		
		calibrate();
		
		zController.driveAlone(2);
		yController.driveAlone(70);
		zController.calibrate();
		
		xController.drive(30,1.0);
		yController.driveAlone(-30);
		xController.drive(-30,1.0);
		yController.driveAlone(-30);		
				
		xController.drive(15,0.5);
		yController.driveAlone(30);
		xController.drive(-15,0.5);
		yController.driveAlone(30);
		
		zController.driveAlone(2);
	}
	
	public void testAxes(){
		calibrate();
		// Test X
		zController.driveAlone(2);
		yController.driveAlone(37.5);
		xController.driveAlone(10);
		zController.calibrate();
		
		xController.driveAlone(50);
		
		zController.driveAlone(2);
		yController.driveAlone(5);
		zController.calibrate();
		
		xController.driveAlone(-50);
		
		calibrate();
		
		// Test Y
		zController.driveAlone(2);
		xController.driveAlone(37.5);
		yController.driveAlone(10);
		zController.calibrate();
		
		yController.driveAlone(50);
		
		zController.driveAlone(2);
		xController.driveAlone(5);
		zController.calibrate();
		
		yController.driveAlone(-50);
		
		zController.driveAlone(2);
	}
	
	public void testPicture(){
		border();
		testAxes();
		testDiagonals();
		testArcs();
	
	}
}
