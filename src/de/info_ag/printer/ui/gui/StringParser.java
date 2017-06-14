package de.info_ag.printer.ui.gui;

import de.info_ag.printer.shape.Point;
import de.info_ag.printer.shape.PrintShape;
import de.info_ag.printer.shape.shapeBuilders.GeometryShapeBuilder;
import de.info_ag.printer.shape.shapeBuilders.PrintShapeBuilder;

public class StringParser {
	
	public PrintShape parse(String parseString){
		PrintShape returnShape = null;
		
		if(parseString.equals("Quadrat")){
			returnShape = GeometryShapeBuilder.createSquareShape(10, new Point(1, 1));
		}
		
		return returnShape;
	}
}
