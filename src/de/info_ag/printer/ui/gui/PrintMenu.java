package de.info_ag.printer.ui.gui;

import de.info_ag.printer.motor.MotorManager;
import de.info_ag.printer.shape.shapeBuilders.PrintShapeBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PrintMenu {
	private MotorManager manager;
	
	private StringParser parser;
	
	private Stage printStage;
	private Scene printScene;
	
	private ObservableList<String> printShapes;
	private ComboBox<String> printShapeBox;
	private Button print;
	private GridPane root;
	
	public PrintMenu(MotorManager manager, PrintShapeBuilder builder){
		this.manager = manager;
		
		parser = new StringParser();
		
		printStage = new Stage();
		
		printShapes = FXCollections.observableArrayList();
		
		printShapeBox = new ComboBox<String>(printShapes);
		
		print = new Button("Drucken");
		
		root = new GridPane();
		
		printScene = new Scene(root, 700, 300);
		
		init();
	}
	
	private void init(){
		printStage.setTitle("MindstormPrinter");
		
		printShapes.add("Quadrat");
		
		root.add(printShapeBox, 0, 0);
		
		root.add(print, 0, 1);
		
		print.setOnAction(e->{
			manager.print(parser.parse(printShapeBox.getValue()));
		});
		
		printStage.setScene(printScene);
	}
	
	public void show(){
		printStage.show();
	}
}
