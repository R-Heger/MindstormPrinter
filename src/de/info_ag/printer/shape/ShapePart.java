package de.info_ag.printer.shape;

/**
 * The class represents a single part of a PrintShape
 *
 */

// TODO are setters needed? is the empty Constructor needed?

public class ShapePart {
	private int x, y;
	private boolean isPrinted;

	/**
	 * @param x
	 *            The x offset of the shapePart
	 * @param y
	 *            The y offset of the shapePart
	 * @param printed
	 *            Whether the shapePart is printed or just a movement
	 */
	public ShapePart(int x, int y, boolean printed) {
		this.x = x;
		this.y = y;
		this.isPrinted = printed;
	}

	/**
	 *
	 */
	public ShapePart() {
		this(0, 0, false);
	}

	/**
	 * @return
	 */
	public int getXParameter() {
		return x;
	}

	/**
	 * @param x
	 */
	public void setXParameter(int x) {
		this.x = x;
	}

	/**
	 * @return
	 */
	public int getYParameter() {
		return y;
	}

	/**
	 * @param
	 */
	public void setYParameter(int y) {
		this.y = y;
	}

	/**
	 * @return Whether the shapePart is printed or just a movement
	 */
	public boolean isPrinted() {
		return isPrinted;
	}

}
