package de.info_ag.printer.ui.gui;

import de.info_ag.printer.shape.Point;
import de.info_ag.printer.shape.PrintShape;
import de.info_ag.printer.shape.PrintShapeBuilder;

public class StringParser {
	private PrintShapeBuilder builder;

	public StringParser(PrintShapeBuilder builder){
		this.builder = builder;
	}
	
	public PrintShape parse(String parseString){
		PrintShape returnShape = null;
		
		if(parseString.equals("Quadrat")){
			returnShape = builder.createSquare(10, new Point(1, 1));
		}
		
		return returnShape;
	}
}
