package fractal;

import mountain.Mountain;
import mountain.Point;
import koch.Koch;

public class FractalApplication {
	public static void main(String[] args) {
		
		Fractal[] fractals = new Fractal[2];
		
		Point a = new Point(-500,-300);
		Point b = new Point(300, 1400);
		Point c = new Point(1400, -400);
	
		fractals[0] = new Koch(300);
		fractals[1] = new Mountain(a, b, c, 200);
	    new FractalView(fractals, "Fraktaler");
	}

}
