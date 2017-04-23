package de.info_ag.printer.main;

import de.info_ag.printer.motor.MotorManager;
import de.info_ag.printer.shape.Point;
import de.info_ag.printer.shape.PrintShape;
import de.info_ag.printer.shape.PrintShapeBuilder;
import de.info_ag.printer.ui.gui.Menu;
import javafx.application.Application;
import javafx.stage.Stage;
import lejos.nxt.Button;

public class Main  extends Application {
	
	private static MotorManager motorManager;
	private static PrintShapeBuilder shapeBuilder;
	
	
	public static void main(String[] args) {
		motorManager = new MotorManager();
		shapeBuilder = new PrintShapeBuilder();
		
//		Button.waitForAnyPress();
		
		launch(args);
		
//		motorManager.calibratePen();
		
//		motorManager.print(shapeBuilder.createTestPicture());		
	}
	
	public void start(Stage arg0) throws Exception {

		motorManager = new MotorManager();
		shapeBuilder = new PrintShapeBuilder();
		
		Menu menu = new Menu(arg0, motorManager, shapeBuilder);
		
		menu.show();
		
	}

}
