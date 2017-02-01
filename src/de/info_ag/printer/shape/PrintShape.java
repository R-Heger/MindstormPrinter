package de.info_ag.printer.shape;

import java.util.LinkedList;

public class PrintShape {
	LinkedList<ShapePart> parts;

	public PrintShape() {
		parts = new LinkedList<ShapePart>();
	}
	
	//PrintShape(startpunkt, skalierung)
	
	//add(PrintShape shape)

	public void attachShapePart(int xParameter, int yParameter, boolean isPrinted) {
		parts.add(new ShapePart(xParameter, yParameter, isPrinted));
	}
}
