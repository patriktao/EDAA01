package mountain;

import java.util.Iterator;
import java.util.LinkedList;

import fractal.Fractal;
import fractal.TurtleGraphics;

public class Mountain extends Fractal {
	private Point a;
	private Point b;
	private Point c;
	private double dev;
	private LinkedList<Side> sides;

	public Mountain(Point a, Point b, Point c, double dev) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.dev = dev;
		sides = new LinkedList<Side>();
	}

	/** returnerar title */

	public String getTitle() {
		return "Mountain";
	}

	/** målar ut hela (drawFractal) */

	public void draw(TurtleGraphics turtle) {
		turtle.moveTo(a.getX(), a.getY());
		drawFractal(turtle, order, a, b, c, dev);

	}

	/**
	 * returnerar en punkt som ligger mitt emellen två punkter
	 * 
	 * @param ldev
	 */

	public Point mid(Point a, Point b, double ldev) {
		double rand = RandomUtilities.randFunc(ldev);

		Point mid = new Point((a.getX() + b.getX()) / 2.0,
				((a.getY() + b.getY()) / 2.0 + rand));

		Side s = new Side(a, b, mid);

		Iterator<Side> itr = sides.iterator();
		while (itr.hasNext()) {
			Side aNext = itr.next();
			if (aNext.equals(s)) {
				itr.remove();
				return aNext.getMid();
			}
		}
		sides.add(s);
		return mid;

	}

	public void drawFractal(TurtleGraphics turtle, int order, Point point1,
			Point point2, Point point3, double nextDev) {

		if (order == 0) {
			drawTriangle(turtle, point1, point2, point3);

		} else {

			Point mid1 = mid(point1, point2, nextDev);
			Point mid2 = mid(point2, point3, nextDev);
			Point mid3 = mid(point3, point1, nextDev);

			nextDev = nextDev / 2;

			drawFractal(turtle, order - 1, point1, mid1, mid3, nextDev);
			drawFractal(turtle, order - 1, point2, mid1, mid2, nextDev);
			drawFractal(turtle, order - 1, point3, mid2, mid3, nextDev);
			drawFractal(turtle, order - 1, mid1, mid2, mid3, nextDev);

		}
	}

	/** Målar ut triangel, börjar i point1 --> point2 --> point3 --> point1 */

	private void drawTriangle(TurtleGraphics turtle, Point point1,
			Point point2, Point point3) {
		turtle.moveTo(point1.getX(), point1.getY());
		turtle.forwardTo(point2.getX(), point2.getY());
		turtle.forwardTo(point3.getX(), point3.getY());
		turtle.forwardTo(point1.getX(), point1.getY());
	}

}
