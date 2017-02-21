package de.info_ag.printer.motor;

import de.info_ag.printer.shape.PrintShape;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;

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
		// TODO
	}
	
	public void lift(){
		zController.driveAlone(30);
	}
	
	public void border(){
		xController.driveAlone(85);
		yController.driveAlone(85);
		xController.driveAlone(-85);
		yController.driveAlone(-85);
	}
	
	public void move(){
//		zController.calibrate();
		
//		xController.drive(40,1.0);
//		yController.driveAlone(40);
//		xController.drive(-40,1.0);
//		yController.driveAlone(40);
//		calibrate();
//		xController.drive(20,0.5);
//		yController.driveAlone(40);
//		xController.drive(-20,0.5);
//		yController.driveAlone(40);
//		zController.driveAlone(2);
	}

}
