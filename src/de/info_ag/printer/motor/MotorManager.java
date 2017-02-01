package de.info_ag.printer.motor;

import de.info_ag.printer.shape.Point;
import de.info_ag.printer.shape.PrintShape;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;

/**
 * The class manages the motor movements and interaction of the 3 axes for
 * printing
 *
 */
public class MotorManager {

	public static final double X_SPEED_CORRECTION = 1.0;
	public static final double Y_SPEED_CORRECTION = 1.0;
	public static final double Z_SPEED_CORRECTION = 1.0;

	public static final double X_MILLIMETER_TO_ROTATION = 86.74;
	public static final double Y_MILLIMETER_TO_ROTATION = 145.94;
	public static final double Z_MILLIMETER_TO_ROTATION = 1.0;

	private MotorController xController;
	private MotorController yController;
	private MotorController zController;

	/**
	 * Inits the 3 MotorController for the 3 axes. Maps each axis a motor and a
	 * touch sensor
	 */
	public MotorManager() {
		xController = new MotorController(Motor.A, SensorPort.S2);
		yController = new MotorController(Motor.B, SensorPort.S4);
		zController = new MotorController(Motor.C, SensorPort.S1);
	}

	/**
	 * Calibrates the axes to their Origin
	 */
	public void calibrate() {
		zController.driveAlone(2 * 360);
		xController.calibrate();
		yController.calibrate();
	}

	/**
	 * @param controller
	 *            The Controller to aclibrate
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

}