package de.info_ag.printer.shape.shapeBuilders;

import de.info_ag.printer.shape.Point;
import de.info_ag.printer.shape.PrintShape;

public class CharShapeBuilder extends PrintShapeBuilder {

	private static final int CHAR_SEPERATION = 2;

	public static PrintShape createStringShape(String string, int fontSize) {
		PrintShape stringShape = parseStringToShape(string);
		stringShape.scale(fontSize / 10);
		return stringShape;
	}

	private static PrintShape parseStringToShape(String toParse) {
		PrintShape parsed = new PrintShape();
		char[] charsToParse = toParse.toCharArray();

		for (char c : charsToParse) {
			PrintShape charShape = getCharShape(c);
			charShape.setStartPoint(new Point(parsed.getEnd().getXCoordinate(), 0));
			parsed.attachPrintShape(charShape);
			parsed.attachShapePart(CHAR_SEPERATION, 0, false);
		}

		return parsed;
	}

	private static PrintShape getCharShape(char c) {
		PrintShape charShape;

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
			charShape = new PrintShape();
			System.err.println("Unknown char!");
			break;
		}

		return charShape;
	}

	private static PrintShape A(int height) {
		PrintShape a = new PrintShape();
		a.attachShapePart(height, height * 0.3, true);
		a.attachShapePart(-height, height * 0.3, true);
		a.attachShapePart(height / 2, -height * 0.15, false);
		a.attachShapePart(0, -height * 0.3, true);
		a.attachShapePart(-height / 2, -height * 0.15, false);
		a.attachShapePart(0, height * 0.8, false);

		return a;

	}

	private static PrintShape B(int height) {
		PrintShape b = new PrintShape();
		b.attachShapePart(0, height, true);
		b.attachShapePart(0.6 * height, -0.25 * height, true);
		b.attachShapePart(-0.6 * height, -0.25 * height, true);
		b.attachShapePart(0.6 * height, -0.25 * height, true);
		b.attachShapePart(-0.6 * height, -0.25 * height, true);
		b.attachShapePart(0.8 * height, 0, false);
		return b;
	}

	public static PrintShape C(int height) {
		PrintShape c = new PrintShape();
		c.attachShapePart(0, height * 0.6, false);

		return c;
	}

	private static PrintShape D(int height) {
		PrintShape d = new PrintShape();
		d.attachShapePart(0, height, true);
		d.attachShapePart(0.6 * height, -0.33 * height, true);
		d.attachShapePart(0, -0.34 * height, true);
		d.attachShapePart(-0.6 * height, -0.33 * height, true);
		d.attachShapePart(0.8 * height, 0, true);
		return d;
	}

	private static PrintShape E(int height) {
		PrintShape e = new PrintShape();
		e.attachShapePart(0, height, true);
		e.attachShapePart(0.6 * height, 0, true);
		e.attachShapePart(-0.6 * height, 0, false);
		e.attachShapePart(0, -0.5 * height, false);
		e.attachPrintShape(e);
		return e;
	}

	public static PrintShape F(int height) {
		PrintShape f = new PrintShape();
		f.attachShapePart(0, height, true);
		f.attachShapePart(0.6 * height, 0, true);
		f.attachShapePart(-0.6 * height, 0, false);
		f.attachShapePart(0, -0.5 * height, false);
		f.attachShapePart(0.4 * height, 0, true);
		f.attachShapePart(height, -0.5 * height, false);
		return f;
	}

	public static PrintShape G(int height) {
		PrintShape g = new PrintShape();

		return g;
	}

	public static PrintShape H(int height) {
		PrintShape h = new PrintShape();
		h.attachShapePart(0, height, true);
		h.attachShapePart(0, -0.5 * height, false);
		h.attachShapePart(0.6 * height, 0, true);
		h.attachShapePart(0, 0.5 * height, false);
		h.attachShapePart(0, -height, true);
		h.attachShapePart(0.8 * height, 0, false);
		return h;
	}

	private static PrintShape I(int height) {
		PrintShape i = new PrintShape();
		i.attachShapePart(0, height, true);
		i.attachShapePart(0.6 * height, height, true);
		return i;
	}

	private static PrintShape J(int height) {
		PrintShape j = new PrintShape();

		return j;
	}

	private static PrintShape K(int height) {
		PrintShape k = new PrintShape();

		return k;
	}

	private static PrintShape L(int height) {
		PrintShape l = new PrintShape();
		l.attachShapePart(0, height, false);
		l.attachShapePart(0, -height, true);
		l.attachShapePart(0.6 * height, 0, true);
		return l;
	}

	private static PrintShape M(int height) {
		PrintShape m = new PrintShape();

		return m;
	}

	private static PrintShape N(int height) {
		PrintShape n = new PrintShape();
		n.attachShapePart(0, height, true);
		n.attachShapePart(0.6 * height, -height, true);
		n.attachShapePart(0, height, true);
		n.attachShapePart(0, -height, false);
		return n;
	}

	private static PrintShape O(int height) {
		PrintShape o = new PrintShape();

		return o;
	}

	private static PrintShape P(int height) {
		PrintShape p = new PrintShape();
		p.attachShapePart(0, height, true);
		p.attachShapePart(0.4 * height, 0, true);
		p.attachShapePart(0.2 * height, -0.2 * height, true);
		p.attachShapePart(0, -0.2 * height, true);
		p.attachShapePart(-0.2 * height, -0.2 * height, true);
		p.attachShapePart(-0.4 * height, 0, true);
		p.attachShapePart(0.6 * height, -0.4 * height, false);
		return p;
	}

	private static PrintShape Q(int height) {
		PrintShape q = new PrintShape();

		return q;
	}

	private static PrintShape R(int height) {
		PrintShape r = new PrintShape();
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

	private static PrintShape S(int height) {
		PrintShape s = new PrintShape();

		return s;
	}

	private static PrintShape T(int height) {
		PrintShape t = new PrintShape();
		t.attachShapePart(0, height, false);
		t.attachShapePart(0.6 * height, 0, true);
		t.attachShapePart(-0.3 * height, 0, false);
		t.attachShapePart(0, -height, true);
		t.attachShapePart(0.3 * height, 0, false);
		return t;
	}

	private static PrintShape U(int height) {
		PrintShape u = new PrintShape();

		return u;
	}

	private static PrintShape V(int height) {
		PrintShape v = new PrintShape();
		v.attachShapePart(0, height, false);
		v.attachShapePart(0.3 * height, -height, true);
		v.attachShapePart(0.3 * height, height, true);
		return v;
	}

	private static PrintShape W(int height) {
		PrintShape w = new PrintShape();

		return w;
	}

	private static PrintShape X(int height) {
		PrintShape x = new PrintShape();
		x.attachShapePart(0.6 * height, height, true);
		x.attachShapePart(-0.6 * height, 0, false);
		x.attachShapePart(0.6 * height, -height, true);
		return x;
	}

	private static PrintShape Y(int height) {
		PrintShape y = new PrintShape();

		return y;
	}

	private static PrintShape Z(int height) {
		PrintShape z = new PrintShape();
		z.attachShapePart(0, height, false);
		z.attachShapePart(0.6 * height, 0, true);
		z.attachShapePart(-0.6 * height, -height, true);
		z.attachShapePart(0.6 * height, 0, true);
		return z;
	}

	private static PrintShape space(int height) {
		PrintShape space = new PrintShape();
		space.attachShapePart(0.5 * height, 0, false);
		return space;

	}

}
