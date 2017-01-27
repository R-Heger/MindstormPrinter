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

	/**
	 * Generates a MotorController, which controls one motor and its sensor
	 *
	 * @param motor
	 *            The motor to control
	 * @param port
	 *            The port of the TouchSensor
	 */
	public MotorController(RemoteMotor motor, SensorPort port) {
		this.motor = motor;
		this.sensor = new TouchSensor(port);
	}

	/**
	 * Rotates the Motor to its startpoint
	 */
	public void calibrate() {
		motor.forward();
		while (!sensor.isPressed()) {
			Delay.msDelay(50);
		}
		motor.stop();
	}

	/**
	 * Rotates the controlled motor for angle degrees. Calling Instance DOES
	 * wait until rotation is complete!
	 *
	 * @param angle
	 *            The angle to rotate in degrees.
	 */
	public void driveAlone(int angle) {
		motor.rotate(angle);
	}

	/**
	 * Rotates the controlled motor for angle degrees. Calling Instance does NOT
	 * wait until rotation is complete!
	 *
	 * @param angle
	 *            The angle to rotate in degrees.
	 */
	public void drive(int angle) {
		motor.rotate(angle, true);
	}

}
