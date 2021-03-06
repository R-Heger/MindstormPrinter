package de.info_ag.printer.motor;

import java.io.DataOutputStream;
import java.io.IOException;

import de.info_ag.printer.shape.PrintShape2D;
import de.info_ag.printer.shape.ShapePart;
import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.pc.comm.NXTCommFactory;
import lejos.pc.comm.NXTConnector;

/**
 * The class manages the motor movements and interaction of the 3 axes for
 * printing
 *
 */
public class MotorManager {

	public static final double X_SPEED_CORRECTION = 1.0;
	public static final double Y_SPEED_CORRECTION = 1.0;
	public static final double Z_SPEED_CORRECTION = 1.0;

	public static final double X_DEGREE_PER_MILLIMETER = 152.1;
	public static final double Y_DEGREE_PER_MILLIMETER = 152.1;
	public static final double Z_DEGREE_PER_MILLIMETER = 576.0;

	private MotorController xController;
	private MotorController yController;
	private MotorController zController;	

	private static NXTConnector con;
	private static DataOutputStream out;

	/**
	 * Inits the 3 MotorController for the 3 axes. Maps each axis a motor and a
	 * touch sensor
	 */
	public MotorManager() {
		xController = new MotorController(Motor.C, SensorPort.S4, false, X_DEGREE_PER_MILLIMETER, X_SPEED_CORRECTION);
		yController = new MotorController(Motor.B, SensorPort.S2, true, Y_DEGREE_PER_MILLIMETER, Y_SPEED_CORRECTION);
		zController = new MotorController(Motor.A, SensorPort.S3, true, Z_DEGREE_PER_MILLIMETER, Z_SPEED_CORRECTION);
		initDataConnection();
	}
	
	private void initDataConnection(){
		con  = new NXTConnector();
		System.out.println("connecting to second NXT...");
		if (con.connectTo("Torwart", "0016530C9390", NXTCommFactory.USB)) {
			System.out.println("connected");
		}
		out = new DataOutputStream(con.getOutputStream());
	}

	/**
	 * Calibrates the axes to their Origin
	 */
	public void calibrate() {
		zController.driveAlone(2);
		xController.calibrate();
		yController.calibrate();
		yController.driveAlone(8);
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
	public void print(PrintShape2D shape) {
		if (shapeIsValid(shape)) {
			boolean printing = true;
			calibrate();
			xController.drive(shape.getStartPoint().getXCoordinate(), 1);
			yController.drive(shape.getStartPoint().getYCoordinate(), 1);
			zController.calibrate();
			for(ShapePart part : shape.getParts()){
				if(part.isPrinted() && !printing){
					printing = true;
					zController.driveAlone(-2);
				} else if(!part.isPrinted() && printing){
					printing = false;
					zController.driveAlone(2);
				}
			
				drive(part);
			}
			lift();
		} else {
			System.err.println("The PrintShape does not matche the bounding box!");
		}
	}
	
	private boolean shapeIsValid(PrintShape2D printShape) {
		int x = printShape.getStartPoint().getXCoordinate();
		int y = printShape.getStartPoint().getYCoordinate();
		for (ShapePart shapePart : printShape.getParts()) {
			x += shapePart.getXParameter();
			y += shapePart.getYParameter();
			if (x > 80 || x < 0 || y > 80 || y < 0) {
				return false;
			} 
		}
		return true;
	}

	private void drive(ShapePart part) {
		double x = part.getXParameter();
		double y = part.getYParameter();
		
		if(Math.abs(x) <= Math.abs(y)){
			xController.drive(part.getXParameter(), Math.abs(x) / Math.abs(y));
			yController.driveAlone(y);
		} else {
			yController.drive(part.getYParameter(), Math.abs(y) / Math.abs(x));
			xController.driveAlone(x);
		}
	}

	private void lift() {
		zController.driveAlone(20);
	}

	public void calibratePen(){
		zController.calibrate();
		Button.waitForAnyPress();
		lift();
	}
	
	private void sendCommand(int command){		
		try {
			out.writeInt(command);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
