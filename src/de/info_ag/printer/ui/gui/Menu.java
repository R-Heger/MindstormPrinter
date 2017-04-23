package de.info_ag.printer.ui.gui;

import de.info_ag.printer.motor.MotorManager;
import de.info_ag.printer.shape.PrintShapeBuilder;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Menu {
	private MotorManager manager;
	@SuppressWarnings("unused")
	private PrintShapeBuilder builder;
	
	private GridPane root;
	private Stage primaryStage;
	private Scene menuScene;
	private Button calibrate;
	private Button print;
	private Button quit;

	public Menu(Stage primary, MotorManager manager, PrintShapeBuilder builder){
		this.primaryStage = primary;
		this.manager = manager;
		this.builder = builder;
		root = new GridPane();
		menuScene = new Scene(root);
		
		calibrate = new Button("Kalibrieren");
		print = new Button("Drucken");
		quit = new Button("Quit");
		
		init();
	}
	
	private void init(){
		root.setPadding(new Insets(64));
		root.setHgap(32);
		root.setVgap(32);
		
		calibrate.setOnAction(e->{
			manager.calibratePen();
		});
		
		print.setOnAction(e->{
			manager.print(builder.createTestPicture());
		});
		
		quit.setOnAction(e->{
			primaryStage.close();
		});
		
		root.add(calibrate, 0, 0);
		root.add(print, 1, 0);
		root.add(quit, 1, 1);
		
		primaryStage.setScene(menuScene);
	}
	
	public void show(){
		primaryStage.show();
	}
}
