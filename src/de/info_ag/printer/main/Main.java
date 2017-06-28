package de.info_ag.printer.main;

import java.io.DataOutputStream;

import de.info_ag.printer.motor.MotorManager;
import de.info_ag.printer.shape.Point;
import de.info_ag.printer.shape.PrintShape2D;
import de.info_ag.printer.shape.shapeBuilders.PrintShapeBuilder;
import de.info_ag.printer.shape.shapeBuilders.TestShapeBuilder;
import de.info_ag.printer.ui.gui.Menu;
import javafx.application.Application;
import javafx.stage.Stage;
import lejos.nxt.Button;
import lejos.pc.comm.NXTCommFactory;
import lejos.pc.comm.NXTConnector;

public class Main  extends Application {
	
	private static MotorManager motorManager;
	private static PrintShapeBuilder shapeBuilder;	
	
	public static void main(String[] args) {
//		initialisation();
		
//		Button.waitForAnyPress();
		
		launch(args);
		
//		motorManager.calibratePen();
		
//		motorManager.print(TestShapeBuilder.createTestPicture1());		
	}
	
	public void start(Stage arg0) throws Exception {
		initialisation();
		
		Menu menu = new Menu(arg0, motorManager, shapeBuilder);
		
		menu.show();
		
	}
	
	private static void initialisation(){
		motorManager = new MotorManager();
	}

}
