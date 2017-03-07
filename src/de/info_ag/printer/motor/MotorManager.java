package de.info_ag.printer.motor;

import de.info_ag.printer.shape.PrintShape;
import de.info_ag.printer.shape.ShapePart;
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
	public static final double Y_DEGREE_PER_MILLIMETER = 152.1;
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
		if (checkShape(shape)) {
// TODO nochmal intensiev drüber nachdenken
// 			insbesondere auf Synchronität der Motoren achten!
//			Und methode ÜBERSICHTLICHER gestalten
			
//			xController.drive(shape.getStartPoint().getXCoordinate(), 1);
//			yController.drive(shape.getStartPoint().getYCoordinate(), 1);
//
//			for (ShapePart part : shape.getParts()) {
//				if (!part.isPrinted()) {
//					zController.driveAlone(2);
//				}
//				if (part.getXParameter() == 0) {
//					yController.drive(part.getYParameter(), 1);
//					if (!part.isPrinted()) {
//						moveZDown();
//					}
//					continue;
//				}
//				if (part.getYParameter() == 0) {
//					xController.drive(part.getXParameter(), 1);
//					if (!part.isPrinted()) {
//						moveZDown();
//					}
//					continue;
//				}
//				double speed = 1;
//				if (part.getXParameter() > part.getYParameter()) {
//					speed = part.getXParameter() / part.getYParameter() * 1.0;
//					xController.drive(part.getXParameter(), speed);
//					yController.drive(part.getYParameter(), 1);
//				} else {
//					speed = part.getYParameter() / part.getXParameter() * 1.0;
//					xController.drive(part.getXParameter(), 1);
//					yController.drive(part.getYParameter(), speed);
//				}
//
//			}
		} else {
			System.err.println("Cant't print that stuff. Time for a Schnitzelbroetchen!");
		}
	}

	//??????????????????????
	private void moveZDown() {

	}

	public void lift() {
		zController.driveAlone(30);
	}

	// Warum aufwändiges Array anlegen und nicht einfach x und y speichern und
	// nach jedem shapePart gucken ob es den Ramen sprengt
	private boolean checkShape(PrintShape printShape) {
		boolean valid = true;
		int[] extremeValues = new int[4];
		extremeValues[0] = printShape.getStartPoint().getXCoordinate();
		extremeValues[1] = printShape.getStartPoint().getYCoordinate();
		extremeValues[2] = printShape.getStartPoint().getXCoordinate();
		extremeValues[3] = printShape.getStartPoint().getYCoordinate();
		outOfBound(extremeValues);// ????

		int x = printShape.getStartPoint().getXCoordinate();
		int y = printShape.getStartPoint().getYCoordinate();
		for (ShapePart shapePart : printShape.getParts()) {
			x += shapePart.getXParameter();
			y += shapePart.getYParameter();
			if (x > extremeValues[0]) {
				extremeValues[0] = x;
			} else if (x < extremeValues[2]) {
				extremeValues[2] = x;
			}

			if (y > extremeValues[1]) {
				extremeValues[1] = y;
			} else if (y < extremeValues[3]) {
				extremeValues[3] = y;
			}

			valid = outOfBound(extremeValues);
		}

		return valid;
	}

	private boolean outOfBound(int coordinates[]) {
		for (int coordinate : coordinates) {
			if (coordinate >= 80 || coordinate <= 0) {
				return false;
			}
		}
		return true;
	}

	public void border() {
		calibrate();

		xController.driveAlone(80);
		yController.driveAlone(80);
		xController.driveAlone(-80);
		yController.driveAlone(-80);
	}

	public void testDiagonals() {
		calibrate();

		xController.drive(80, 1);
		yController.driveAlone(80);

		calibrate();

		zController.driveAlone(2);
		yController.driveAlone(80);
		zController.calibrate();

		xController.drive(80, 1);
		yController.driveAlone(-80);
	}

	public void testArcs() {
		calibrate();

		zController.driveAlone(2);
		xController.driveAlone(10);
		zController.calibrate();

		xController.drive(30, 1.0);
		yController.driveAlone(30);
		xController.drive(30, 1.0);
		yController.driveAlone(-30);

		yController.drive(15, 0.5);
		xController.driveAlone(-30);
		yController.drive(-15, 0.5);
		xController.driveAlone(-30);

		calibrate();

		zController.driveAlone(2);
		xController.driveAlone(80);
		yController.driveAlone(10);
		zController.calibrate();

		xController.drive(-30, 1.0);
		yController.driveAlone(30);
		xController.drive(30, 1.0);
		yController.driveAlone(30);

		xController.drive(-15, 0.5);
		yController.driveAlone(-30);
		xController.drive(15, 0.5);
		yController.driveAlone(-30);

		calibrate();

		zController.driveAlone(2);
		xController.driveAlone(70);
		yController.driveAlone(80);
		zController.calibrate();

		xController.drive(-30, 1.0);
		yController.driveAlone(-30);
		xController.drive(-30, 1.0);
		yController.driveAlone(30);

		yController.drive(-15, 0.5);
		xController.driveAlone(30);
		yController.drive(15, 0.5);
		xController.driveAlone(30);

		calibrate();

		zController.driveAlone(2);
		yController.driveAlone(70);
		zController.calibrate();

		xController.drive(30, 1.0);
		yController.driveAlone(-30);
		xController.drive(-30, 1.0);
		yController.driveAlone(-30);

		xController.drive(15, 0.5);
		yController.driveAlone(30);
		xController.drive(-15, 0.5);
		yController.driveAlone(30);

		zController.driveAlone(2);
	}

	public void testAxes() {
		calibrate();
		// Test X
		zController.driveAlone(2);
		yController.driveAlone(37.5);
		xController.driveAlone(15);
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
		yController.driveAlone(15);
		zController.calibrate();

		yController.driveAlone(50);

		zController.driveAlone(2);
		xController.driveAlone(5);
		zController.calibrate();

		yController.driveAlone(-50);

		zController.driveAlone(2);
	}

	public void testPicture() {
		border();
		testAxes();
		testDiagonals();
		testArcs();

	}
}
