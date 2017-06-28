package de.info_ag.printer.ui.gui;

import de.info_ag.printer.shape.Point;
import de.info_ag.printer.shape.PrintShape2D;
import de.info_ag.printer.shape.shapeBuilders.GeometryShapeBuilder;
import de.info_ag.printer.shape.shapeBuilders.PrintShapeBuilder;

public class StringParser {
	
	public PrintShape2D parse(String parseString){
		PrintShape2D returnShape = null;
		
		if(parseString.equals("Quadrat")){
			returnShape = GeometryShapeBuilder.createSquareShape(10, new Point(1, 1));
		}
		
		return returnShape;
	}
}
