package de.info_ag.printer.ui.gui;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ShapeDetails {
	private Stage detailsStage;
	
	private ArrayList<String> options;
	private ArrayList<Button> optionsButton;
	
	public ShapeDetails(ArrayList<String> options){
		this.options = options;
		
		detailsStage = new Stage();
		
		init();
	}
	
	private void init(){
		detailsStage.setTitle("Print Details");
		
		for(String option : options){
			optionsButton.add(new Button(option));
		}
	}

}
