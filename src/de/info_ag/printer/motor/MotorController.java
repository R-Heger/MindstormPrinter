package de.info_ag.printer.motor;

import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.remote.RemoteMotor;
import lejos.util.Delay;

/**
 * The class takes controll on a single motor
 *
 */
public class MotorController {
	private RemoteMotor motor;
	private TouchSensor sensor;
	private double millimeterToRotation;

	/**
	 * Generates a MotorController, which controls one motor and its sensor
	 *
	 * @param motor
	 *            The motor to control
	 * @param port
	 *            The port of the TouchSensor
	 * @param invertDirection Whether the movments of this motor should run to the inverted direction
	 * @param millimeterToRotation Correction value for converting millimeter input to degree output
	 */
	public MotorController(RemoteMotor motor, SensorPort port, boolean invertDirection, double millimeterToRotation) {
		this.motor = motor;
		this.sensor = new TouchSensor(port);
		this.millimeterToRotation = millimeterToRotation * (invertDirection? -1 : 1);
	}

	/**
	 * Moves the Motor to its startpoint
	 */
	public void calibrate() {
		motor.forward();
		while (!sensor.isPressed()) {
			Delay.msDelay(50);
		}
		motor.stop();
	}

	/**
	 * Moves the controlled axis for length millimeters. Calling Instance DOES
	 * wait until movement is complete!
	 *
	 * @param length
	 *            The length in millimeter to move in degrees.
	 */
	public void driveAlone(int length) {
		motor.rotate((int)(length * millimeterToRotation));
	}

	/**
	 * Moves the controlled axis for length millimeters. Calling Instance does NOT
	 * wait until movement is complete!
	 *
	 * @param length
	 *            The length in millimeter to move in degrees.
	 */
	public void drive(int length) {
		motor.rotate((int)(length * millimeterToRotation), true);
	}

}
