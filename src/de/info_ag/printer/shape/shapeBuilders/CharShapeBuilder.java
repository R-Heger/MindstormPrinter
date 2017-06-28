package de.info_ag.printer.shape.shapeBuilders;

import de.info_ag.printer.shape.Point;
import de.info_ag.printer.shape.PrintShape2D;

public class CharShapeBuilder extends PrintShapeBuilder {

	private static final int CHAR_SEPERATION = 2;

	public static PrintShape2D createStringShape(String string, int fontSize) {
		PrintShape2D stringShape = parseStringToShape(string);
		stringShape.scale(fontSize / 10);
		return stringShape;
	}

	private static PrintShape2D parseStringToShape(String toParse) {
		PrintShape2D parsed = new PrintShape2D();
		char[] charsToParse = toParse.toCharArray();

		for (char c : charsToParse) {
			PrintShape2D charShape = getCharShape(c);
			charShape.setStartPoint(new Point(parsed.getEnd().getXCoordinate(), 0));
			parsed.attachPrintShape(charShape);
			parsed.attachShapePart(CHAR_SEPERATION, 0, false);
		}

		return parsed;
	}

	private static PrintShape2D getCharShape(char c) {
		PrintShape2D charShape;

		switch (c) {
		case 'A':
			charShape = A(10);
			break;

		case 'B':
			charShape = B(10);
			break;

		case 'C':
			charShape = C(10);
			break;

		case 'D':
			charShape = D(10);
			break;

		case 'E':
			charShape = E(10);
			break;

		case 'F':
			charShape = F(10);
			break;

		case 'G':
			charShape = G(10);
			break;

		case 'H':
			charShape = H(10);
			break;

		case 'I':
			charShape = I(10);
			break;

		case 'J':
			charShape = J(10);
			break;

		case 'K':
			charShape = K(10);
			break;

		case 'L':
			charShape = L(10);
			break;

		case 'M':
			charShape = M(10);
			break;

		case 'N':
			charShape = N(10);
			break;

		case 'O':
			charShape = O(10);
			break;

		case 'P':
			charShape = P(10);
			break;

		case 'Q':
			charShape = Q(10);
			break;

		case 'R':
			charShape = R(10);
			break;

		case 'S':
			charShape = S(10);
			break;

		case 'T':
			charShape = T(10);
			break;

		case 'U':
			charShape = U(10);
			break;

		case 'V':
			charShape = V(10);
			break;

		case 'W':
			charShape = W(10);
			break;

		case 'X':
			charShape = X(10);
			break;

		case 'Y':
			charShape = Y(10);
			break;

		case 'Z':
			charShape = Z(10);
			break;

		case ' ':
			charShape = space(10);
			break;

		default:
			charShape = new PrintShape2D();
			System.err.println("Unknown char!");
			break;
		}

		return charShape;
	}

	private static PrintShape2D A(int height) {
		PrintShape2D a = new PrintShape2D();
		a.attachShapePart(height, height * 0.3, true);
		a.attachShapePart(-height, height * 0.3, true);
		a.attachShapePart(height / 2, -height * 0.15, false);
		a.attachShapePart(0, -height * 0.3, true);
		a.attachShapePart(-height / 2, -height * 0.15, false);
		a.attachShapePart(0, height * 0.8, false);

		return a;

	}

	private static PrintShape2D B(int height) {
		PrintShape2D b = new PrintShape2D();
		b.attachShapePart(0, height, true);
		b.attachShapePart(0.6 * height, -0.25 * height, true);
		b.attachShapePart(-0.6 * height, -0.25 * height, true);
		b.attachShapePart(0.6 * height, -0.25 * height, true);
		b.attachShapePart(-0.6 * height, -0.25 * height, true);
		b.attachShapePart(0.8 * height, 0, false);
		return b;
	}

	public static PrintShape2D C(int height) {
		PrintShape2D c = new PrintShape2D();
		c.attachShapePart(0, height * 0.6, false);

		return c;
	}

	private static PrintShape2D D(int height) {
		PrintShape2D d = new PrintShape2D();
		d.attachShapePart(0, height, true);
		d.attachShapePart(0.6 * height, -0.33 * height, true);
		d.attachShapePart(0, -0.34 * height, true);
		d.attachShapePart(-0.6 * height, -0.33 * height, true);
		d.attachShapePart(0.8 * height, 0, true);
		return d;
	}

	private static PrintShape2D E(int height) {
		PrintShape2D e = new PrintShape2D();
		e.attachShapePart(0, height, true);
		e.attachShapePart(0.6 * height, 0, true);
		e.attachShapePart(-0.6 * height, 0, false);
		e.attachShapePart(0, -0.5 * height, false);
		e.attachPrintShape(e);
		return e;
	}

	public static PrintShape2D F(int height) {
		PrintShape2D f = new PrintShape2D();
		f.attachShapePart(0, height, true);
		f.attachShapePart(0.6 * height, 0, true);
		f.attachShapePart(-0.6 * height, 0, false);
		f.attachShapePart(0, -0.5 * height, false);
		f.attachShapePart(0.4 * height, 0, true);
		f.attachShapePart(height, -0.5 * height, false);
		return f;
	}

	public static PrintShape2D G(int height) {
		PrintShape2D g = new PrintShape2D();

		return g;
	}

	public static PrintShape2D H(int height) {
		PrintShape2D h = new PrintShape2D();
		h.attachShapePart(0, height, true);
		h.attachShapePart(0, -0.5 * height, false);
		h.attachShapePart(0.6 * height, 0, true);
		h.attachShapePart(0, 0.5 * height, false);
		h.attachShapePart(0, -height, true);
		h.attachShapePart(0.8 * height, 0, false);
		return h;
	}

	private static PrintShape2D I(int height) {
		PrintShape2D i = new PrintShape2D();
		i.attachShapePart(0, height, true);
		i.attachShapePart(0.6 * height, height, true);
		return i;
	}

	private static PrintShape2D J(int height) {
		PrintShape2D j = new PrintShape2D();

		return j;
	}

	private static PrintShape2D K(int height) {
		PrintShape2D k = new PrintShape2D();

		return k;
	}

	private static PrintShape2D L(int height) {
		PrintShape2D l = new PrintShape2D();
		l.attachShapePart(0, height, false);
		l.attachShapePart(0, -height, true);
		l.attachShapePart(0.6 * height, 0, true);
		return l;
	}

	private static PrintShape2D M(int height) {
		PrintShape2D m = new PrintShape2D();

		return m;
	}

	private static PrintShape2D N(int height) {
		PrintShape2D n = new PrintShape2D();
		n.attachShapePart(0, height, true);
		n.attachShapePart(0.6 * height, -height, true);
		n.attachShapePart(0, height, true);
		n.attachShapePart(0, -height, false);
		return n;
	}

	private static PrintShape2D O(int height) {
		PrintShape2D o = new PrintShape2D();

		return o;
	}

	private static PrintShape2D P(int height) {
		PrintShape2D p = new PrintShape2D();
		p.attachShapePart(0, height, true);
		p.attachShapePart(0.4 * height, 0, true);
		p.attachShapePart(0.2 * height, -0.2 * height, true);
		p.attachShapePart(0, -0.2 * height, true);
		p.attachShapePart(-0.2 * height, -0.2 * height, true);
		p.attachShapePart(-0.4 * height, 0, true);
		p.attachShapePart(0.6 * height, -0.4 * height, false);
		return p;
	}

	private static PrintShape2D Q(int height) {
		PrintShape2D q = new PrintShape2D();

		return q;
	}

	private static PrintShape2D R(int height) {
		PrintShape2D r = new PrintShape2D();
		r.attachShapePart(0, height, true);
		r.attachShapePart(0.4 * height, 0, true);
		r.attachShapePart(0.2 * height, -0.2 * height, true);
		r.attachShapePart(0, -0.2 * height, true);
		r.attachShapePart(-0.2 * height, -0.2 * height, true);
		r.attachShapePart(-0.4 * height, 0, true);
		r.attachShapePart(0.4 * height, 0, false);
		r.attachShapePart(0.2 * height, -0.4 * height, true);
		return r;
	}

	private static PrintShape2D S(int height) {
		PrintShape2D s = new PrintShape2D();

		return s;
	}

	private static PrintShape2D T(int height) {
		PrintShape2D t = new PrintShape2D();
		t.attachShapePart(0, height, false);
		t.attachShapePart(0.6 * height, 0, true);
		t.attachShapePart(-0.3 * height, 0, false);
		t.attachShapePart(0, -height, true);
		t.attachShapePart(0.3 * height, 0, false);
		return t;
	}

	private static PrintShape2D U(int height) {
		PrintShape2D u = new PrintShape2D();

		return u;
	}

	private static PrintShape2D V(int height) {
		PrintShape2D v = new PrintShape2D();
		v.attachShapePart(0, height, false);
		v.attachShapePart(0.3 * height, -height, true);
		v.attachShapePart(0.3 * height, height, true);
		return v;
	}

	private static PrintShape2D W(int height) {
		PrintShape2D w = new PrintShape2D();

		return w;
	}

	private static PrintShape2D X(int height) {
		PrintShape2D x = new PrintShape2D();
		x.attachShapePart(0.6 * height, height, true);
		x.attachShapePart(-0.6 * height, 0, false);
		x.attachShapePart(0.6 * height, -height, true);
		return x;
	}

	private static PrintShape2D Y(int height) {
		PrintShape2D y = new PrintShape2D();

		return y;
	}

	private static PrintShape2D Z(int height) {
		PrintShape2D z = new PrintShape2D();
		z.attachShapePart(0, height, false);
		z.attachShapePart(0.6 * height, 0, true);
		z.attachShapePart(-0.6 * height, -height, true);
		z.attachShapePart(0.6 * height, 0, true);
		return z;
	}

	private static PrintShape2D space(int height) {
		PrintShape2D space = new PrintShape2D();
		space.attachShapePart(0.5 * height, 0, false);
		return space;

	}

}
