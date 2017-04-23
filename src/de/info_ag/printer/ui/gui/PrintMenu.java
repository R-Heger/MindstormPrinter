package de.info_ag.printer.ui.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PrintMenu {
	private Stage printStage;
	
	private ObservableList<String> printShapes;
	private ComboBox<String> printShapeBox;
	private GridPane root;
	
	public PrintMenu(){
		printStage = new Stage();
		
		printShapes = FXCollections.observableArrayList("Quadrat");
		
		printShapeBox = new ComboBox<String>(printShapes);
		
		init();
	}
	
	private void init(){
		
	}
	
	public void show(){
		printStage.show();
	}
}
