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
	public static int BASE_SPEED = 800;
	
	private RemoteMotor motor;
	private TouchSensor sensor;
	private double degreePerMillimeter;
	private double speedCorrection;

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
	public MotorController(RemoteMotor motor, SensorPort port, boolean invertDirection, double degreePerMillimeter,
				double speedCorrection) {
		this.motor = motor;
		this.sensor = new TouchSensor(port);
		this.degreePerMillimeter = degreePerMillimeter * (invertDirection? -1 : 1);
		this.speedCorrection = speedCorrection;
		this.motor.setAcceleration(1000);
		this.motor.setSpeed((int) (speedCorrection * BASE_SPEED));
	}

	/**
	 * Moves the Motor to its startpoint
	 */
	public void calibrate() {
		if(degreePerMillimeter < 0){
			motor.forward();
		} else {
			motor.backward();
		}
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
	public void driveAlone(double length) {
		motor.rotate((int)(length * degreePerMillimeter));
	}

	/**
	 * Moves the controlled axis for length millimeters. Calling Instance does NOT
	 * wait until movement is complete!
	 *
	 * @param length
	 *            The length in millimeter to move in degrees.
	 */
	public void drive(double length, double speed) {
		motor.setSpeed((int)(speed * speedCorrection * BASE_SPEED));
		motor.rotate((int)(length * degreePerMillimeter), true);
	}

}
